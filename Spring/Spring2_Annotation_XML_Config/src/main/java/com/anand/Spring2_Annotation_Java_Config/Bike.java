package com.anand.Spring2_Annotation_Java_Config;

import org.springframework.stereotype.Component;

@Component // now this bike is component
public class Bike implements Vehicle{
	
	public void drive() {
		System.out.println("Bike is running at 50kms");
	}
}
