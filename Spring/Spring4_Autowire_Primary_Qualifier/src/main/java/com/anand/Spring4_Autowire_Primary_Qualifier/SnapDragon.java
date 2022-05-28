package com.anand.Spring4_Autowire_Primary_Qualifier;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SnapDragon implements MobileProcessor {

	public void process() {
		System.out.println("World Best CPU");
	}
	
}
