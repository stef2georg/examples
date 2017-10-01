package com.epam.reference;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class SoftReferenceMain {

    public static void main(String[] args) {
        Object object = new Object();
        SoftReference<Object> notCleanedReference = new SoftReference<>(object);
        SoftReference<Object> cleanedReference = new SoftReference<>(new Object());

        System.out.println("Not cleaned reference before GC: " + notCleanedReference.get());
        System.out.println("Cleaned reference before GC: " + cleanedReference.get());

        System.gc();

        System.out.println("Not cleaned reference after GC: " + notCleanedReference.get());
        System.out.println("Cleaned reference after GC: " + cleanedReference.get());

        // Cause out of memory (OOM).
        try {
            Map<Integer, Object> map = new HashMap<>();
            for (int index = 0; index < Integer.MAX_VALUE; index++) {
                map.put(index, new long[index]);
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("Not cleaned reference after OOM: " + notCleanedReference.get());
        System.out.println("Cleaned reference after OOM: " + cleanedReference.get());
    }

}
