package com.example.demo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "class-name", havingValue = "App2Impl")
public class App2Impl implements IApp {

	@Override
	public String getName() {
		return this.getClass().getName();
	}

}
