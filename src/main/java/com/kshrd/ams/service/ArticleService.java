package com.kshrd.ams.service;

import java.util.List;

import com.kshrd.ams.model.Article;
import com.kshrd.ams.model.ArticleFilter;
import com.kshrd.ams.utility.Paging;

public interface ArticleService {
	boolean insert(Article article);
	Article findOne(int id);
	List<Article> findAll();
	boolean update(Article article);
	boolean delete(int id);
	
	List<Article> findAllFilter(ArticleFilter filter, Paging paging);
}
