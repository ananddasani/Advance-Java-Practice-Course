package com.anand.Spring4_Autowire_Primary_Qualifier;

import org.springframework.stereotype.Component;

@Component
public class MediaTek implements MobileProcessor{

	public void process() {
		System.out.println("Second Best CPU");
	};
}
