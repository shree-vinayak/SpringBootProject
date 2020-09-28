package com.example.controllers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadControllers {

	public static String uploadDirectory = System.getProperty("user.dir") + "\\uploads";

	@GetMapping("/")
	public String UploadPage(Model model) {
		return "uploadview";
	}

	@PostMapping("/upload")
	public String upload(Model model, @RequestParam("files") MultipartFile[] files) throws IOException {

		StringBuilder fileNames = new StringBuilder();

		for (MultipartFile file : files) {
			Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
			fileNames.append(file.getOriginalFilename() + " ");
			
			InputStream fis = file.getInputStream();
			BufferedInputStream    bis = new BufferedInputStream (fis);

		     FileOutputStream fos = new FileOutputStream (fileNameAndPath.toString());
		     BufferedOutputStream  bos = new BufferedOutputStream (fos);
		     int byte_;
		     while ((byte_ = bis.read ()) != -1)
		       bos.write (byte_);

		     
		     
		     bos.close();
//			try {
//				InputStream in=file.getInputStream();
//				
//				Files.write(fileNameAndPath, file.getBytes());
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		model.addAttribute("msg", "Successfully uploaded file " + fileNames);
		return "uploadstatusview";
	}
}
