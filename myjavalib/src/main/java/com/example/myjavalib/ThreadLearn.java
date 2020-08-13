package com.example.myjavalib;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadLearn {
    public static void main(String[] args) {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "123";
            }
        };
        FutureTask<String> stringFutureTask = new FutureTask<>(callable);
        new Thread(stringFutureTask).start();
        try {
            System.out.println(stringFutureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
