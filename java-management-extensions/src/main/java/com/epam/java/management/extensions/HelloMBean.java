package com.epam.java.management.extensions;

public interface HelloMBean {

    void sayHello();

    int add(int x, int y);

    String getName();

    int getCacheSize();

    void setCacheSize(int cacheSize);

}
