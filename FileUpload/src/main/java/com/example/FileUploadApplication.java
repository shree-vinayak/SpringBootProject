package com.example;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.controllers.FileUploadControllers;

@SpringBootApplication
public class FileUploadApplication {

	public static void main(String[] args) {

		new File(FileUploadControllers.uploadDirectory).mkdir();
		SpringApplication.run(FileUploadApplication.class, args);
	}

}
