package com.anand.Spring2_Annotation_Java_Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // now this car is component
public class Car implements Vehicle {
	
	@Autowired // 
	private Tyre tyre;

	public void drive() {
		System.out.println("Car is running at 90kms");
	}

	public Tyre getTyre() {
		return tyre;
	}

	public void setTyre(Tyre tyre) {
		this.tyre = tyre;
	}
	
}

/*
 * the dafault name for this Car is "car" (non qualified and di-capilatized)
 */
