package com.epam.reference;

import java.lang.ref.Cleaner;

public class CleanerMain {

    public static void main(String[] args) throws InterruptedException {
        Cleaner cleaner = Cleaner.create();

        Object object = new Object();
        Cleaner.Cleanable cleanable = cleaner.register(object, new CleanAction(1));
        cleaner.register(new Object(), new CleanAction(2));

        System.out.println("Before GC.");

        System.gc();
        Thread.sleep(1000);

        System.out.println("After GC.");

        cleanable.clean();

        System.out.println("After first call to clean.");

        cleanable.clean();

        System.out.println("After second call to clean.");
    }

    private static class CleanAction implements Runnable {

        private int index;

        CleanAction(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            System.out.println("Object cleaned! Index: " + index);
        }
    }

}
