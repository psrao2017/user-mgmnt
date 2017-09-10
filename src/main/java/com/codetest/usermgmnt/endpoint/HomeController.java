package com.codetest.usermgmnt.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String home(){
		return "welcome to code test!!";
	}
}
