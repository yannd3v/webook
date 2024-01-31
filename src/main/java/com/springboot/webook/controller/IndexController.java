package com.springboot.webook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/webook")
	public String index() {
		return "index.html";
	}
}
