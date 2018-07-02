package com.kshrd.ams.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kshrd.ams.service.upload.FileUploadService;

@RestController
@RequestMapping("/api/v1")
public class FileUploadRestController {

	@Autowired
	private FileUploadService fileUploadService;
	
	@PostMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file) {
		return "http://localhost:8080" + fileUploadService.upload(file);
	}
	
}















