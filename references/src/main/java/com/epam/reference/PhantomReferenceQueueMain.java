package com.epam.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceQueueMain {

    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        ReferenceQueue<Object> notCleanedQueue = new ReferenceQueue<>();
        PhantomReference<Object> notCleanedReference = new PhantomReference<>(object, notCleanedQueue);

        ReferenceQueue<Object> cleanedQueue = new ReferenceQueue<>();
        PhantomReference<Object> cleanedReference = new PhantomReference<>(new Object(), cleanedQueue);

        System.out.println("Not cleaned queue before GC: " + notCleanedQueue.poll());
        System.out.println("Not cleaned reference before GC: " + notCleanedReference.get());
        System.out.println("Cleaned queue before GC: " + cleanedQueue.poll());
        System.out.println("Cleaned reference before GC: " + cleanedReference.get());

        System.gc();

        System.out.println("Not cleaned queue after OOM: " + notCleanedQueue.poll());
        System.out.println("Not cleaned reference after OOM: " + notCleanedReference);
        System.out.println("Cleaned queue after OOM: " + cleanedQueue.poll());
        System.out.println("Cleaned reference after OOM: " + cleanedReference);
    }

    private static class FinalizedObject {
        @Override
        protected void finalize() throws Throwable {
            super.finalize();
        }
    }

}
