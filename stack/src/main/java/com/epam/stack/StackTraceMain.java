package com.epam.stack;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StackTraceMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            executorService.submit(new Task("Des")).get();
        } finally {
            executorService.shutdownNow();
        }
    }

    private static class Task implements Runnable {

        private String name;

        private Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            int number = 11;
            String postfix = "pasito";

            throw new RuntimeException(name + postfix + number);
        }

    }

}
