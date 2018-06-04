package com.kshrd.ams.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kshrd.ams.model.Article;
import com.kshrd.ams.service.ArticleService;

@Controller
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;

	@GetMapping("/article")
	public String article(ModelMap model) {
		List<Article> articles = articleService.findAll();
//		System.out.println(articles);
		model.addAttribute("articles", articles);
		return "article";
	}
	
	@GetMapping("/article/{id}")
	public String articleOne(@PathVariable("id") int id, ModelMap model) {
		
		model.addAttribute("article", articleService.findOne(id));
		return "article_detail";
	}
	
	@GetMapping("/test")
	public String articleOneaaa(@RequestParam("a_id") int id, ModelMap model) {
		
		model.addAttribute("article", articleService.findOne(id));
		return "article_detail";
	}
	
	@GetMapping("/add")
	public String addArticle(ModelMap m) {
		m.addAttribute("article", new Article());
		return "add";
	}
	
	@PostMapping("/add")
	public String saveArticle(@ModelAttribute Article article) {
		article.setCreatedDate(new Date().toString());
		System.out.println(article);
		articleService.insert(article);
		return "redirect:/article";
	}
	
}
