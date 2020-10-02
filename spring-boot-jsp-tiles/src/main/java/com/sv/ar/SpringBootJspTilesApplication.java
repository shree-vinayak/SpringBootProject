package com.sv.ar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootJspTilesApplication extends SpringBootServletInitializer {

	private static Class<SpringBootJspTilesApplication> applicationClass = SpringBootJspTilesApplication.class;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJspTilesApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}

}
