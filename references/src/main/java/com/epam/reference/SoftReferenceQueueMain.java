package com.epam.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class SoftReferenceQueueMain {

    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        ReferenceQueue<Object> notCleanedQueue = new ReferenceQueue<>();
        SoftReference<Object> notCleanedReference = new SoftReference<>(object, notCleanedQueue);

        ReferenceQueue<Object> cleanedQueue = new ReferenceQueue<>();
        SoftReference<Object> cleanedReference = new SoftReference<>(new Object(), cleanedQueue);

        System.out.println("Not cleaned queue before GC: " + notCleanedQueue.poll());
        System.out.println("Cleaned queue before GC: " + cleanedQueue.poll());

        System.gc();

        System.out.println("Not cleaned queue after GC: " + notCleanedQueue.poll());
        System.out.println("Cleaned queue after GC: " + cleanedQueue.poll());

        // Cause out of memory (OOM).
        try {
            Map<Integer, Object> map = new HashMap<>();
            for (int index = 0; index < Integer.MAX_VALUE; index++) {
                map.put(index, new long[index]);
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("Not cleaned queue after OOM: " + notCleanedQueue.poll());
        System.out.println("Not cleaned reference after OOM: " + notCleanedReference + " with object: " + notCleanedReference.get());
        System.out.println("Cleaned queue after OOM: " + cleanedQueue.poll());
        System.out.println("Cleaned reference after OOM: " + cleanedReference + " with object: " + cleanedReference.get());
    }

}
