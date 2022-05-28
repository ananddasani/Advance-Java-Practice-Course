package com.anand.Spring4_Autowire_Primary_Qualifier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		
		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);

		Realme narzo = factory.getBean(Realme.class);
		narzo.config();
	}
}

/*
 * In this project we will remove both the bean from AppConfig.java
 * by using @component-scan() annotation
 * 
 * 
 * But when we have MediaTek along with SnapDragon (implements MobilePorcessor)
 * how to specify which one we want
 *  
 * so using Autowired Primary Qualifier and making SnapDragon Primary (@Primary)
 * 
 * also using @Qualifier("mediaTek") 
 */
