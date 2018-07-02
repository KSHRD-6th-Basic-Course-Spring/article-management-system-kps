package com.kshrd.ams.service.upload;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
	String upload(MultipartFile file);
	String upload(MultipartFile file, String folder);
	List<String> upload(List<MultipartFile> files);
	List<String> upload(List<MultipartFile> files, String folder);
}
