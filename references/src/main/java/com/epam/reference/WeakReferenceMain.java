package com.epam.reference;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class WeakReferenceMain {

    public static void main(String[] args) {
        Object object = new Object();
        WeakReference<Object> notCleanedReference = new WeakReference<>(object);
        WeakReference<Object> cleanedReference = new WeakReference<>(new Object());

        System.out.println("Not cleaned reference before GC: " + notCleanedReference.get());
        System.out.println("Cleaned reference before GC: " + cleanedReference.get());

        System.gc();

        System.out.println("Not cleaned reference after GC: " + notCleanedReference.get());
        System.out.println("Cleaned reference after GC: " + cleanedReference.get());

        WeakHashMap<Key, Object> weakHashMap = new WeakHashMap<>();
    }

    private static class Key {
        @Override
        public boolean equals(Object other) {
            return this == other;
        }
    }

}
