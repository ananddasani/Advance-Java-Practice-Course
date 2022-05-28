package com.anand.Spring3_Java_Config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	//Dependency :(
//        Realme realme = new Realme();
//        realme.config();
    	
    	ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	Realme narzo = factory.getBean(Realme.class);
    	narzo.config();
    }
}

/*
 * In this project no xml file for configuration will be used 
 * instead complete java configuration will be followed 
 * 
 * for that AppConfig class is one of them (replacing xml file)
 */