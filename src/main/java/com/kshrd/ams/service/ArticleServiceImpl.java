package com.kshrd.ams.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kshrd.ams.model.Article;
import com.kshrd.ams.repository.ArticleRepository;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepository articleRepo;
	
	@Override
	public void insert(Article article) {
		articleRepo.insert(article);
	}

	@Override
	public Article findOne(int id) {
		return articleRepo.findOne(id);
	}

	@Override
	public List<Article> findAll() {
		return articleRepo.findAll();
	}

}
