package com.wingchi.user.util;

import org.springframework.context.ApplicationContext;

public class Springutil {
    private static ApplicationContext applicationContext ;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        Springutil.applicationContext = applicationContext;
    }
}
