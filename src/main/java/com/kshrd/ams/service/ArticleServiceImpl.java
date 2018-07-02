package com.kshrd.ams.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kshrd.ams.model.Article;
import com.kshrd.ams.model.ArticleFilter;
import com.kshrd.ams.repository.article.ArticleRepository;
import com.kshrd.ams.utility.Paging;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepository articleRepo;
	
	@Override
	public boolean insert(Article article) {
		return articleRepo.insert(article);
	}

	@Override
	public Article findOne(int id) {
		return articleRepo.findOne(id);
	}

	@Override
	public List<Article> findAll() {
		return articleRepo.findAll();
	}
	
	@Override
	public boolean update(Article article) {
		return articleRepo.update(article);
	}
	
	@Override
	public boolean delete(int id) {
		return articleRepo.delete(id);
	}
	
	@Override
	public List<Article> findAllFilter(ArticleFilter filter, Paging paging) {
		paging.setTotalCount(articleRepo.countAllArticles(filter));
		return articleRepo.findAllFilter(filter, paging);
	}

}
