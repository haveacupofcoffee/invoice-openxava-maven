package com.codingforfun.schedule;

import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebContextLoaderListener extends ContextLoaderListener {
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("WebContextLoaderListener Initialized.");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("WebContextLoaderListener Destroyed.");
    }

}
