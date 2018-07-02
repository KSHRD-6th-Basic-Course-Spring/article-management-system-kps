package com.kshrd.ams.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@PropertySource("classpath:ams.properties")
public class FileUploadController {
	
	@Value("${file.server.path}")
	String serverPath;
	
	@GetMapping("/upload")
	public String upload() {
		return "upload";
	}
	
	@PostMapping("/upload")
	public String saveFile(@RequestParam("files") List<MultipartFile> files) {
		
		if(!files.isEmpty()) {
			files.forEach(file -> {
				String fileName = UUID.randomUUID() + "." + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
				try {
					Files.copy(file.getInputStream(), Paths.get(serverPath, fileName));
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		}
		
		return "redirect:/upload";
	}
	
}
