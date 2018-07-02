package com.kshrd.ams.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kshrd.ams.model.Article;
import com.kshrd.ams.model.ArticleFilter;
import com.kshrd.ams.service.ArticleService;
import com.kshrd.ams.service.CategoryService;
import com.kshrd.ams.utility.Paging;

@Controller
@PropertySource("classpath:ams.properties")
public class ArticleController {
	
	@Value("${file.server.path}")
	private String serverPath;
	
	@Value("${file.client.path}")
	private String clientPath;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping(value = {"/", "/home", "/index"})
	public String redirectToHomePage() {
		return "redirect:/article";
	}
	
	@GetMapping("/article")
	public String article(ArticleFilter filter, Paging paging, ModelMap m) {
		List<Article> articles = articleService.findAllFilter(filter, paging);
		m.addAttribute("articles", articles);
		m.addAttribute("filter", filter);
		m.addAttribute("categories", categoryService.findAll());
		return "article";
	}
	
	@GetMapping("/add")
	public String add(ModelMap m) {
		m.addAttribute("article", new Article());
		m.addAttribute("categories", categoryService.findAll());
		m.addAttribute("formAdd", true);
		return "add";
	}
	
	@PostMapping("/add")
	public String saveArticle(@RequestParam("image") MultipartFile thumbnail, @Valid @ModelAttribute Article article, BindingResult result, ModelMap m) {
		if(result.hasErrors()) {
			System.out.println("BINDING ERROR");
			System.out.println(result);
			m.addAttribute("article", article);
			m.addAttribute("formAdd", true);
			return "add";
		}
		
		
		if (thumbnail.isEmpty()) {
			System.out.println("FILE EMPTY");
			return "add";
		} else {
			try {
				Files.copy(thumbnail.getInputStream(), Paths.get(serverPath, thumbnail.getOriginalFilename()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		article.setThumbnail("/image/" + thumbnail.getOriginalFilename());
		
		article.setCreatedDate(new Date().toString());
		article.setCategory(categoryService.findOne(article.getCategory().getId()));
		articleService.insert(article);
		return "redirect:/article";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		articleService.delete(id);
		return "redirect:/article";
	}
	
	@GetMapping("/article/{id}")
	public String articleDetail(@PathVariable("id") int id, ModelMap m) {
		m.addAttribute("article", articleService.findOne(id));
		return "detail";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, ModelMap m) {
		m.addAttribute("article", articleService.findOne(id));
		m.addAttribute("categories", categoryService.findAll());
		m.addAttribute("formAdd", false);
		return "add";
	}
	
	@PostMapping("/update")
	public String saveUpdate(@ModelAttribute Article article) {
		article.setCategory(categoryService.findOne(article.getCategory().getId()));
		articleService.update(article);
		return "redirect:/article";
	}
	
}
