package com.example.demo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "class-name", havingValue = "App1Impl")
public class App1Impl implements IApp {

	@Override
	public String getName() {
		return this.getClass().getName();
	}

}
