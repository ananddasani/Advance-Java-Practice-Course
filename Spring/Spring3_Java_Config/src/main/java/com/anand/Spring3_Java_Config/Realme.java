package com.anand.Spring3_Java_Config;

import org.springframework.beans.factory.annotation.Autowired;

public class Realme {
	
	@Autowired
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