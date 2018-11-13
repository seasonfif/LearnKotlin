package com.seasonfif.learnkotlin.concurrent;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumer {

    public static void main(String...args){
        Queue<Integer> queue = new LinkedList<>();

        new Produc(queue).start();
        new Consum(queue).start();
        new Consum(queue).start();
        new Consum(queue).start();
    }


    private static class Produc extends Thread{
        private final Queue<Integer> queue;

        public Produc(Queue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while(true){
                synchronized (queue){
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (queue.size() >= 10){
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    int num = new Random().nextInt(100) + 1;
                    queue.offer(num);

                    System.out.println(getName() + "生产：" + num);

                    queue.notifyAll();
                }
            }

        }
    }


    private static class Consum extends Thread{

        private final Queue<Integer> queue;

        public Consum(Queue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true){
                synchronized (queue){
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (queue.size() == 0){
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    int num = queue.poll();
                    System.out.println(getName() + "消费：" + num);

                    queue.notifyAll();

                }

            }

        }
    }
}


