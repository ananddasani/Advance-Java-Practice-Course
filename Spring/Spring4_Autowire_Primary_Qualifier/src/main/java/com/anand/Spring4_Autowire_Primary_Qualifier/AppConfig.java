package com.anand.Spring4_Autowire_Primary_Qualifier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.anand.Spring4_Autowire_Primary_Qualifier")
public class AppConfig {
	
//	@Bean // this must return bean (when used with getBean() in app.java)
//	public Realme gtRealme() {
//		return new Realme();
//	}
//	
//	@Bean
//	public MobileProcessor getProcessor() {
//		return new SnapDragon();
//	}

}

/*
 * we will remove this both the bean now
 */