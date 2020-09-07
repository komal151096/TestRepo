package com.tanmay.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String showPage()
	{
		return "main-menu"; // main-menu is a view page (.jsp)
		
		
	}
}
