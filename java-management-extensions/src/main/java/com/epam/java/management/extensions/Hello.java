package com.epam.java.management.extensions;

public class Hello implements HelloMBean {

    private int cacheSize = 100;

    @Override
    public void sayHello() {
        System.out.println("Chalamba!");
    }

    @Override
    public int add(int x, int y) {
        return x + y;
    }

    @Override
    public String getName() {
        return "Kondio";
    }

    @Override
    public int getCacheSize() {
        return cacheSize;
    }

    @Override
    public synchronized void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }
}
