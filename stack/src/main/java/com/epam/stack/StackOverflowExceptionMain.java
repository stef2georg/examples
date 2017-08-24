package com.epam.stack;

public class StackOverflowExceptionMain {

    public static void main(String[] args) {
        infiniteRecursiveCall();
    }

    private static int infiniteRecursiveCall() {
        return infiniteRecursiveCall();
    }

}
