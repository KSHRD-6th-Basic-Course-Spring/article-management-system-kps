package com.kshrd.ams.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AjaxArticleController {

	@GetMapping("/ajax/article")
	public String findAll() {
		return "ajax/article";
	}
	
	@GetMapping("/ajax/add")
	public String add() {
		return "ajax/add";
	}
	
}
