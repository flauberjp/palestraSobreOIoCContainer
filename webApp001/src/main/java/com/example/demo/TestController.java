package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	IApp app;
	
	public TestController(IApp app ) {
		this.app = app;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	String getAppName() {
		return app.getName();
	}
}
