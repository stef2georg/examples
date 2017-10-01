package com.epam.java.management.extensions;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class JavaManagementExtensionsMain {

    public static void main(String[] args) throws Exception {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

        mBeanServer.registerMBean(new Hello(), new ObjectName("com.epam.java.management.extensions:type=Hello"));

        Thread.sleep(Long.MAX_VALUE);
    }

}
