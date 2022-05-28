package com.anand.Spring1_XML_Config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
//    	//this is dependent :( (as you type new )
//        Car car = new Car();
//        car.drive();
//        
//        //I am having also bike 
//        Bike bike = new Bike();
//        bike.drive();
        
        //using beans 
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        
        //now we have an interface named vehicle 
        //so now we will use spring framework to remove the dependence
        Vehicle obj = (Vehicle) applicationContext.getBean("vehicle"); //vehicle but which (car or bike ?)
        obj.drive();
    }
}

/*
 * In future if we want to change from car to bike 
 * then there is dependence
 * 
 * we have dependence on left and right side :(
 * 
 * we can use BeanFactory (recommended for small projects) or ApplicationContext for spring framework
 * we will be using ApplicationContext 
 * 
 * dependency injections is removed by this line in spring.xml file
 * <bean id="vehicle" class="com.anand.Spring1_XML_Config.Bike"></bean>
 * 
 * in spring 3 ways we can do configuration
 * 1. xml
 * 2. annotatinons
 * 3. java
 */