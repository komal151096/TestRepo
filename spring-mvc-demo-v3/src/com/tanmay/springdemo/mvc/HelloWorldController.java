package com.tanmay.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	// need a controller method to show initial HTML form
	@RequestMapping("/showForm")
	public String showForm()
	{
		return "helloworld-form";
	}
	// need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm()
	{
		return "helloworld";
	}
	
	// new controller method to read form data
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model)
	{
		// read the request parameter from the HTML form
		String theName = request.getParameter("studentName");
		
		// convert the data in uppercase
		theName = theName.toUpperCase();
		
		//  create the message
		String result = "Yo!" + theName;
		
		// add message to the model
		model.addAttribute("message", result);
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName,
			Model model)
	{
		// read the request parameter from the HTML form
		//String theName = request.getParameter("studentName");
		
		// convert the data in uppercase
		theName = theName.toUpperCase();
		
		//  create the message
		String result = "Hey my friend from version 3" + theName;
		
		// add message to the model
		model.addAttribute("message", result);
		return "helloworld";
	}
	

}
