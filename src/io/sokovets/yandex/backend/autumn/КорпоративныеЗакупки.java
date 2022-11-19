package io.sokovets.yandex.backend.autumn;

/**
 * Стартап Алисы Селезневой и Зелибобы привлек к себе внимание крупных инвесторов. Часть полученных от инвесторов денег было решено потратить на обновление офиса — новая мебель, оргтехника и другие прикольные штуки.
 * Алиса и Зелибоба выдвинули
 * 5
 *  критериев — товар должен удовлетворять всем данным критериям, чтобы его закупили в обновленный офис.
 *
 * «Наименование товара содержит подстроку в любом регистре» (критерий ‘NAME_CONTAINS’);
 * «Цена больше либо равна чем» (критерий ‘PRICE_GREATER_THAN’);
 * «Цена меньше либо равна чем» (критерий ‘PRICE_LESS_THAN’);
 * «Товар поступил в продажу не позднее чем» (критерий ‘DATE_BEFORE’);
 * «Товар поступил в продажу не ранее чем» (критерий ‘DATE_AFTER’);
 * Закупаться было решено в Выньдекс.Рынке. Для такого крупного клиента Выньдекс.
 *
 * Рынок предоставил стартапу персонального менеджера — да-да, именно вас.
 *
 * Первым делом вам необходимо из имеющегося списка товаров на складе выбрать все товары, удовлетворяющие выданным Алисой и Зелибобой критериям.
 */


/** Вход
 * [{"id": 1, "name": "Asus notebook","price": 1564,"date": "23.09.2021"},{"price": 2500, "id": 3, "date": "05.06.2020", "name": "Keyboardpods" }, {"date": "23.09.2021", "name": "Airpods","id": 5, "price": 2300}, {"name": "EaRPoDs", "id": 2, "date": "01.01.2022", "price": 2200}, { "id": 4, "date": "23.09.2021", "name": "Dell notebook",  "price": 2300}]
 * PRICE_LESS_THAN 2400
 * DATE_AFTER 23.09.2021
 * NAME_CONTAINS pods
 * PRICE_GREATER_THAN 2200
 * DATE_BEFORE 02.01.2022
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

/** Выход
 * [{"name": "EaRPoDs", "id": 2, "date": "01.01.2022", "price": 2200}, {"date": "23.09.2021", "name": "Airpods", "id": 5, "price": 2300}]
 */


public class КорпоративныеЗакупки {

    enum Filters {
        NAME_CONTAINS, PRICE_GREATER_THAN, PRICE_LESS_THAN, DATE_BEFORE, DATE_AFTER;
    }


    private class Product {
        private int id;
        private String name;
        private int price;
        private LocalDate date;
    }


    //Здесь нужно сделать Builder
    private static class Filter {

        private String name;
        private int priceGreaterThanOrEquals;
        private int priceLessThanOrEquals;
        private LocalDate dateAfter;
        private LocalDate dateBefore;

        public Filter(String name, int priceGreaterThanOrEquals, int priceLessThanOrEquals, LocalDate dateAfter, LocalDate dateBefore) {
            this.name = name;
            this.priceGreaterThanOrEquals = priceGreaterThanOrEquals;
            this.priceLessThanOrEquals = priceLessThanOrEquals;
            this.dateAfter = dateAfter;
            this.dateBefore = dateBefore;
        }
    }

    public static void main(String[] args) throws IOException {
        String[] line = Files.readString(Paths.get("/Users/19434089/IdeaProjects/HackerrankTasks/src/io/sokovets/yandex/backend/autumn/КорпоративныеЗакупкиВходнойФайлПример.txt")).split("\n");

        //1. Распарсим в список объектов Products
        //2. Далее можно ли сделать Predicate который будет композитоный состояить из тех значений которые есть в Filter
        //3. Отсортировать список по predicate
        //4. Преобразовать строку в JSON и потом вывести его

    }


    /**
     * Возвращаем фильтр
     * @param filter
     * @return
     */
    private Filter parseFilter(String[] filter) {

        //Builder.Filter filter = new Builder();

        for (int i = 1; i < filter.length; i++) {

            if (filter[i].contains(Filters.NAME_CONTAINS.name())) {

            } else if (filter[i].contains(Filters.PRICE_GREATER_THAN.name())) {

            } else if (filter[i].contains(Filters.PRICE_LESS_THAN.name())) {

            } else if (filter[i].contains(Filters.DATE_AFTER.name())) {
                //Смотреть чтобы даты были в диапозоне 01.01.1970 и 31.12.2070
            } else if (filter[i].contains(Filters.DATE_BEFORE.name())) {

            }
        }

        return null;
    }


}
