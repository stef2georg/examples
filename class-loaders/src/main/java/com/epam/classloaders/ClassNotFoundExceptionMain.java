package com.epam.classloaders;

import java.lang.reflect.InvocationTargetException;

public class ClassNotFoundExceptionMain {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> threadClass = ClassNotFoundExceptionMain.class.getClassLoader().loadClass("java.lang.Thread");
        Thread thread = (Thread) threadClass.newInstance();
        System.out.println(thread);

        Class<?> fikiClass = ClassNotFoundExceptionMain.class.getClassLoader().loadClass("java.lang.Fiki");
        Object fikiObject = fikiClass.newInstance();
        fikiClass.getMethod("askToni").invoke(fikiObject);
    }

}
