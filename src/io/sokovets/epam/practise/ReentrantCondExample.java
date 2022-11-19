package io.sokovets.epam.practise;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Пример использования Condition
 * Пример ReentrantCondExample демонстрирует использование объекта условия Condition с блокировкой ReentrantLock.
 * В примере описывается торговый склад, в который производитель завозит товар из списка GOODS. Товар регистрируется в коллекции goods. Потребитель забирает товар со склада.
 * <p>
 * В конструкторе примера создаются торговый склад store и два потока : producer, consumer, исходный код которых представлен ниже.
 * Метод printMessage выводит сообщения потоков в консоль.
 *
 * await()	- Переводит поток в состояние ожидания до тех пор, пока не будет выполнено некоторое условие или пока другой поток не вызовет методы signal/signalAll
 * await(long time, TimeUnit unit)	- Переводит поток в состояние ожидания на определенное время пока не будет выполнено некоторое условие или пока другой поток не вызовет методы signal/signalAll
 * signal()	- Сигнализирует потоку, у которого ранее был вызван метод await(), о возможности продолжения работы. Применение аналогично использованию методу notify класса Object
 * signalAll()	- Сигнализирует всем потокам, у которых ранее был вызван метод await(), о возможности продолжения работы. Применение аналогично использованию методу notifyAll класса Object
 */
public class ReentrantCondExample {

    Store store = null;
    SimpleDateFormat simpleDateFormat = null;
    final String[] GOODS = {"Молоко", "Кефир", "Ряженка", "Кофе", "Чай"};
    List<String> goods = new ArrayList<>();

    public ReentrantCondExample() {
        store = new Store();
        simpleDateFormat = new SimpleDateFormat("HH:mm:ss  ");
        Thread producer = new Thread(new Producer());
        Thread consumer = new Thread(new Consumer());
        producer.start(); //Стартанули producer
        consumer.start();

        while (producer.isAlive() || consumer.isAlive()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\nЗавершение работы примера");
    }

    public static void main(String[] args) {
        new ReentrantCondExample();
    }


    //Производитель
    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < GOODS.length; i++) {
                store.put(GOODS[i]);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    //Потребитель
    class Consumer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < GOODS.length; i++) {
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            store.get(); //Забираем из Store
        }
    }

    // Склад с товаром
    //Класс Store включает метод получения товара put и метод выдачи товара get.
    // Шаблон выполнения операций обоих методов идентичен : сначала метод получает блокировку,
    // чтобы другой поток не вошел в данный метод; после этого выполняется проверка условий.
    // Если условия не соблюдаются, то поток переводится в стадию ожидания методом cond.await().
    // Для второго потока условия должны быть соблюдены (такая бизнес-логика работы склада), и он должен выполнить свою операцию.
    // После этого второй поток «будит» первый, а сам завершает операцию и разблокирует метод.
    // «Разбуженный» первый поток вновь выполняет проверку условия, и далее действует согласно предписанному
    // сценарию (либо продолжение выполнения, либо переход в ожидание).
    class Store {
        ReentrantLock reentrantLock; //блокировка
        Condition condition; //условие блокировки


        //Инициализация склада
        Store() {
            reentrantLock = new ReentrantLock();
            condition = reentrantLock.newCondition();
        }

        public void get() {
            reentrantLock.lock();

            try {
                // ожидание на пустом складе
                while (goods.size() < 1) {
                    condition.await(); //Ожидаем поступления товара
                }

                System.out.println("Реализация : " + goods.get(0));
                goods.remove(0);

                // Сигнализация
                condition.signalAll();

            } catch (InterruptedException e) {
            } finally {
                reentrantLock.unlock();
            }
        }

        public void put(final String good) {
            reentrantLock.lock();
            try {
                // ожидание освобождения места
                while (goods.size() >= 3) {
                    condition.await();
                }

                goods.add(good);
                System.out.println("Доставка : " + good);

                condition.signalAll();

            } catch (InterruptedException e) {

            } finally {
                reentrantLock.unlock();
            }
        }


    }
}


