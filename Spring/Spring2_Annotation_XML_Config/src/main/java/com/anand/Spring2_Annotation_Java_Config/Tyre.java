package com.anand.Spring2_Annotation_Java_Config;

import org.springframework.stereotype.Component;

@Component
public class Tyre {

	String brand;

	public Tyre(String brand) {
		super();
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Tyre [brand=" + brand + "]";
	}
	
}
