package com.seasonfif.learnkotlin.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {

    public static void main(String[] args){

        ExecutorService pool = Executors.newFixedThreadPool(3);

        Future f = pool.submit(new Runnable() {
            @Override
            public void run() {

            }
        });

        try {
            Object i = f.get();
            System.out.println(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Future<Integer> ff = pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() {
                return 3;
            }
        });

        try {
            System.out.println(ff.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("finish");

        FutureTask<String> fff = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "FutureTask<String>";
            }
        });

        new Thread(fff).start();
        try {
            System.out.println(fff.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("finish");
    }
}
