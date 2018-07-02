package com.kshrd.ams.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.kshrd.ams.model.ArticleFilter;
import com.kshrd.ams.service.ArticleService;
import com.kshrd.ams.utility.Paging;

@Controller
public class ThymeleafAjaxController {

	@Autowired
	private ArticleService articleService;
	
	@GetMapping("/thymeleaf-ajax/article-table")
	public String articleTable(ArticleFilter filter, Paging paging, ModelMap m) {
		m.addAttribute("articles", articleService.findAllFilter(filter, paging));
		return "fragments/thymeleaf-ajax :: article-table";
	}
	
	@GetMapping("/thymeleaf-ajax/articles")
	public String article() {
		return "thymeleaf-ajax-page";
	}
	
	
	
	
	
	
	
	
	
	
}
