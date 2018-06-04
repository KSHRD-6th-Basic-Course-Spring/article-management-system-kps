package com.kshrd.ams.model;

public class Article {
	private int id;
	private String title;
	private String description;
	private String createdDate;
	private String author;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public Article() {}

	public Article(int id, String title, String description, String createdDate, String author) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.createdDate = createdDate;
		this.author = author;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", description=" + description + ", createdDate="
				+ createdDate + ", author=" + author + "]";
	}

}
