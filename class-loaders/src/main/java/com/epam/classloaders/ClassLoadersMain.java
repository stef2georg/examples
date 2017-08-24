package com.epam.classloaders;

public class ClassLoadersMain {

    public static void main(String[] args) {
        System.out.println(
                Object.class + ": " + Object.class.getClassLoader()
        );

        System.out.println(
                Class.class + ": " + Class.class.getClassLoader()
        );

        System.out.println(
                String.class + ": " + String.class.getClassLoader()
        );

        System.out.println(
                Thread.class + ": " + Thread.class.getClassLoader()
        );

        System.out.println(
                ClassLoadersMain.class + ": " + ClassLoadersMain.class.getClassLoader()
        );

        System.out.println(
                ClassNotFoundExceptionMain.class + ": " + ClassNotFoundExceptionMain.class.getClassLoader()
        );

        System.out.println(
                ClassLoadersMain.class.getClassLoader() + ": " + ClassLoadersMain.class.getClassLoader().getParent()
        );

        System.out.println(
                ClassLoadersMain.class.getClassLoader().getParent() + ": " + ClassLoadersMain.class.getClassLoader().getParent().getParent()
        );
    }

}
