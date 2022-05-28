package com.anand.Spring3_Java_Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //this is the configuration file/class (replacement of xml file)
public class AppConfig {
	
	@Bean // this must return bean (when used with getBean() in app.java)
	public Realme gtRealme() {
		return new Realme();
	}
	
	@Bean
	public MobileProcessor getProcessor() {
		return new SnapDragon();
	}
}
