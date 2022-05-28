package com.anand.Spring4_Autowire_Primary_Qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Realme {
	
	@Autowired
	@Qualifier("mediaTek") // not using @Primary and mentioning i need mediaTek
	MobileProcessor cpu;

	public void config() {
		System.out.println("Octa Core, 6 GB Ram");
		
		cpu.process();
	}
	
	public MobileProcessor getCpu() {
		return cpu;
	}

	public void setCpu(MobileProcessor cpu) {
		this.cpu = cpu;
	}	
}

/*
 * in order to connect two things (cpu bean and config bean)
 * use autoWired annotation
 */