package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/index")
public class index {
	
	@GetMapping(value = "/hello")
	public String home()
	{
		return "hello manav patel";
	}
	
	@GetMapping(value = "/customhello")
	public String passParaHello(@RequestParam String fname  , @RequestParam (value = "lname" , required = false , defaultValue = "")String lname)
	{
		return "hello " + fname+ " " + lname ;
	}
	
	@GetMapping(value = "/customhello/{customerid}/hello")
	
	public String customHello1(
			@RequestHeader(value = "Accept") String accept,
			@PathVariable String customerid , 
			@RequestParam String name)
	{
		System.out.println(accept);
		if(accept.equals("application/json"))
		{
			System.out.println("if called");
		}
		else
		{
			System.out.println("else called");
		}
		return "hello" + " "+ customerid+ " " + name;
		
	}

}
