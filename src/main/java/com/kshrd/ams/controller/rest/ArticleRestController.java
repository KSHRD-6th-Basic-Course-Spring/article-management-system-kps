package com.kshrd.ams.controller.rest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kshrd.ams.model.Article;
import com.kshrd.ams.model.ArticleFilter;
import com.kshrd.ams.service.ArticleService;
import com.kshrd.ams.utility.Paging;

@RestController
@RequestMapping("/api/v1")
public class ArticleRestController {
	
	private ArticleService articleService;
	
	public ArticleRestController(ArticleService articleService) {
		this.articleService = articleService;
	}

	@GetMapping("/articles")
	public Map<String, Object> findAll(ArticleFilter filter, Paging paging) {
		Map<String, Object> response = new HashMap<>();
		List<Article> articles = articleService.findAllFilter(filter, paging);
		
		if (articles.isEmpty()) {
			response.put("status", false);
			response.put("message", "There is no articles!");
		} else {
			response.put("status", true);
			response.put("message", "Retrived articles successfully.");
			response.put("data", articles);
			response.put("paging", paging);
		}
		
		return response;
	}
	
	@GetMapping("/articles/{article_id}")
	public Map<String, Object> findOne(@PathVariable("article_id") int id) {
		Map<String, Object> response = new HashMap<>();
		Article article = articleService.findOne(id);
		
		if (article == null) {
			response.put("status", false);
			response.put("message", "Article not found!");
		} else {
			response.put("status", true);
			response.put("message", "Article found.");
			response.put("data", article);
		}
		
		return response;
	}
	
	@PostMapping("/articles")
	public Map<String, Object> insert(@RequestBody Article article) {
		Map<String, Object> response = new HashMap<>();
		article.setCreatedDate(new Date().toString());
				
		if (articleService.insert(article)) {
			response.put("status", true);
			response.put("message", "Article inseted successfully.");
			response.put("data", articleService.findOne(article.getId()));
		} else {
			response.put("status", false);
			response.put("message", "Article inserted failed!");
		}
		
		return response;
	}
	
	@DeleteMapping("/articles/{id}")
	public ResponseEntity<Map<String, Object>> delete(@PathVariable int id) {
		Map<String, Object> response = new HashMap<>();
				
		if (articleService.delete(id)) {
			response.put("status", true);
			response.put("message", "Deleted successfully.");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
		} else {
			response.put("status", false);
			response.put("message", "Deleted failed.");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PutMapping("/articles")
	public Map<String, Object> update(@RequestBody Article article) {
		Map<String, Object> response = new HashMap<>();
		article.setCreatedDate(new Date().toString());
				
		if (articleService.update(article)) {
			response.put("status", true);
			response.put("message", "Article updated successfully.");
			response.put("data", articleService.findOne(article.getId()));
		} else {
			response.put("status", false);
			response.put("message", "Article updated failed!");
		}
		
		return response;
	}
	
	
	
	
	
	
	
	
	
	
}









