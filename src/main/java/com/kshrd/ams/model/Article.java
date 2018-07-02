package com.kshrd.ams.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Article {

	@NotNull
	private int id;
	@NotEmpty
	private String title;
	@NotBlank
	@Size(min = 10, max = 30)
	private String description;

	private Category category;

	private String thumbnail;
	private String createdDate;
	@NotBlank
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

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Article(int id, String title, String description, Category category, String thumbnail, String createdDate,
			String author) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.category = category;
		this.thumbnail = thumbnail;
		this.createdDate = createdDate;
		this.author = author;
	}

	public Article() {
		super();
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", description=" + description + ", category=" + category
				+ ", thumbnail=" + thumbnail + ", createdDate=" + createdDate + ", author=" + author + "]";
	}

}
