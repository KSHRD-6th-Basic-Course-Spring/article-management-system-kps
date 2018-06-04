package com.kshrd.ams.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.javafaker.Faker;
import com.kshrd.ams.model.Article;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository {

	private ArrayList<Article> articles = new ArrayList<>();
	
	public ArticleRepositoryImpl() {
		Faker faker = new Faker();
		for(int i=1; i<=10; i++)
			articles.add(new Article(i, faker.book().title(), faker.book().title(), new Date().toString(), faker.name().fullName()));
	}
	
	@Override
	public void insert(Article article) {
		articles.add(article);
	}

	@Override
	public Article findOne(int id) {
		for(Article a : articles) {
			if (a.getId() == id) {
				return a;
			}
		}
		return null;
	}

	@Override
	public List<Article> findAll() {
		return articles;
	}
	
}
