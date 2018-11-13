package com.seasonfif.learnkotlin.concurrent;

public class WaitDemo {

    static Object lock = new Object();
   static String count = "season";

   public static void main(String...args) {

       Thread t = new Thread(new Runnable() {
           @Override
           public void run() {
               count += "fif";
               try {
                   Thread.sleep(3000);
                   /*synchronized (lock){
                       lock.notify();
                       System.out.println(count.toString() + " progress: " + count);
                   }*/
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       });
       t.start();
       try {
           t.join();
       } catch (InterruptedException e) {
           e.printStackTrace();
       }


       /*synchronized (lock){
           try {
               System.out.println(count.toString() + " result: " + count);
               lock.wait();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println(count.toString() + " result: " + count);
       }*/

       System.out.println("result: " + count);
   }
}
