package com.epam.loggers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerMain {

    public static void main(String[] args) {
        Logger defaultLogger = LoggerFactory.getLogger(LoggerMain.class);
        Logger parentLogger = LoggerFactory.getLogger("parent");
        Logger childLogger = LoggerFactory.getLogger("parent.child");

        String name = "Suzanita";
        int age = 16;
        defaultLogger.error("Default error {} {}", name, age);

        Exception exception = new Exception();
        defaultLogger.error("Default error exception", exception);

        defaultLogger.warn("Default warn");
        defaultLogger.info("Default info");
        defaultLogger.debug("Default debug");
        defaultLogger.trace("Default trace");

        parentLogger.error("Parent error");
        parentLogger.warn("Parent warn");
        parentLogger.info("Parent info");
        parentLogger.debug("Parent debug");
        parentLogger.trace("Parent trace");

        childLogger.error("Child error");
        childLogger.warn("Child warn");
        childLogger.info("Child info");
        childLogger.debug("Child debug");
        childLogger.trace("Child trace");
    }

}
