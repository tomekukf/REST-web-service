package com.tomek.domek.helloWord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController()

public class HelloWorldController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	
	@GetMapping(path="/hello-world") 
	public String helloWord() {
		return "Hello World";
	}
	
	@GetMapping(path="/hello-world-bean") 
	public HelloWorldBean helloWordBean() {
		log.info("hello - wrolds");
		return new HelloWorldBean("Hello World");
		
	}
	@GetMapping(path="/hello-world-bean/{param}") 
	public HelloWorldBean helloWordBeanOne(@PathVariable String param) {
		log.info("hello - wrolds");  
		return new HelloWorldBean(String.format("Hello World - %s",param));
		
	}
	
 
}
