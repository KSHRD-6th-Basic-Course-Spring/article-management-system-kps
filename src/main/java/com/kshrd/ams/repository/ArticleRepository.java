package com.kshrd.ams.repository;

import java.util.List;

import com.kshrd.ams.model.Article;

public interface ArticleRepository {
	
	void insert(Article article);
	Article findOne(int id);
	List<Article> findAll();
	
	
}
