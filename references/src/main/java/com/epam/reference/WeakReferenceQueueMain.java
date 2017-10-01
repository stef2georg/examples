package com.epam.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class WeakReferenceQueueMain {

    public static void main(String[] args) {
        Object object = new Object();
        ReferenceQueue<Object> notCleanedQueue = new ReferenceQueue<>();
        WeakReference<Object> notCleanedReference = new WeakReference<>(object, notCleanedQueue);

        ReferenceQueue<Object> cleanedQueue = new ReferenceQueue<>();
        WeakReference<Object> cleanedReference = new WeakReference<>(new Object(), cleanedQueue);

        System.out.println("Not cleaned queue before GC: " + notCleanedQueue.poll());
        System.out.println("Cleaned queue before GC: " + cleanedQueue.poll());

        System.gc();

        System.out.println("Not cleaned queue after GC: " + notCleanedQueue.poll());
        System.out.println("Not cleaned reference after GC: " + notCleanedReference + " with object: " + notCleanedReference.get());
        System.out.println("Cleaned queue after GC: " + cleanedQueue.poll());
        System.out.println("Cleaned reference after GC: " + cleanedReference + " with object: " + cleanedReference.get());
    }

}
