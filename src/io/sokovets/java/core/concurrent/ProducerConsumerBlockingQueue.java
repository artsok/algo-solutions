package io.sokovets.java.core.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * https://www.javamadesoeasy.com/2015/03/producer-consumer-pattern-using-custom.html
 */

/**
 * Producer Class in java.
 */
class Producer implements Runnable {

    private final BlockingQueue<Integer> sharedQueue;

    public Producer(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for(int i=1; i<=10; i++){
            try {
                System.out.println("Produced : " + i);
                //put/produce into sharedQueue.
                sharedQueue.put(i); //Inserts the specified element into this queue only if space is available else waits for space to become available.
            } catch (InterruptedException ex) {

            }
        }
    }

}

/**
 * Consumer Class in java.
 */
class Consumer implements Runnable{

    private BlockingQueue<Integer> sharedQueue;

    public Consumer (BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while(true){
            try {
                //take/consume from sharedQueue.

                //Retrieves and removes the head of this queue Retrieves and removes the head of this queue waits for element to become available.
                System.out.println("CONSUMED : "+ sharedQueue.take());
            } catch (InterruptedException ex) {

            }
        }
    }


}

public class ProducerConsumerBlockingQueue {

    public static void main(String args[]){

        //Creating shared object
        BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<>();

        Producer producer=new Producer(sharedQueue);
        Consumer consumer=new Consumer(sharedQueue);

        Thread producerThread = new Thread(producer, "ProducerThread");
        Thread consumerThread = new Thread(consumer, "ConsumerThread");

        //Стартанули поток
        producerThread.start();
        consumerThread.start();

    }

}