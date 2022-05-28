package com.anand.Spring2_Annotation_Java_Config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        
        Tyre tyre = (Tyre) applicationContext.getBean("tyre");
        System.out.println(tyre);
    }
}

/*
 * In this project we will do configuration with annotaions (Java based configuration)
 * 
 * in spring 3 ways we can do configuration
 * 1. xml
 * 2. annotatinons
 * 3. java
 * 
 * so here we will remove partly -> spring.xml, bean
 * and will use @Component and @AutoWired annotations instead of bean
 * 
 * also in Tyre Class i have done Construtor Injection
 */