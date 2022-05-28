package com.anand;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //telling this is controller
public class AddController {
	
	@RequestMapping("/add") //for add request we have to call this add method 
	public String add() {
		System.out.println("Adding two numbers");
		
		return "display.jsp";
	}
}
