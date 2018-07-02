package com.kshrd.ams.repository.article;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.kshrd.ams.model.Article;
import com.kshrd.ams.model.ArticleFilter;
import com.kshrd.ams.repository.provider.ArticleProvider;
import com.kshrd.ams.utility.Paging;

@Repository
public interface ArticleRepository {
	
	@Insert("INSERT INTO tb_articles(title, description, author, thumbnail, created_date, category_id) VALUES(#{title}, #{description}, #{author}, #{thumbnail}, #{createdDate}, #{category.id})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public boolean insert(Article article);
	
	@Select("SELECT a.id, a.title, a.description, a.author, a.thumbnail, a.created_date, a.category_id, c.name as category_name "
			+ "from tb_articles a INNER JOIN tb_categories c "
			+ "ON a.category_id=c.id WHERE a.id=#{id}")
	@Results({
		@Result(property="id", column="id"),
		@Result(property="title", column="title"),
		@Result(property="description", column="description"),
		@Result(property="author", column="author"),
		@Result(property="thumbnail", column="thumbnail"),
		@Result(property="createdDate", column="created_date"),
		@Result(property="category.id", column="category_id"),
		@Result(property="category.category", column="category_name")
	})
	public Article findOne(int id);
	
	@Select("SELECT a.id, a.title, a.description, a.author, a.thumbnail, a.created_date, a.category_id, c.name as category_name "
			+ "from tb_articles a INNER JOIN tb_categories c "
			+ "ON a.category_id=c.id ORDER BY a.id ASC")
	@Results({
		@Result(property="createdDate", column="created_date"),
		@Result(property="category.id", column="category_id"),
		@Result(property="category.category", column="category_name")
	})
	public List<Article> findAll();
	
	@Update("UPDATE tb_articles SET title=#{title}, description=#{description}, author=#{author}, category_id=#{category.id} WHERE id=#{id}")
	public boolean update(Article article);
	
	@Delete("DELETE FROM tb_articles WHERE id=#{id}")
	public boolean delete(int id);
	
	
	@SelectProvider(method="findAllFilter", type=ArticleProvider.class)
	@Results({
		@Result(property="createdDate", column="created_date"),
		@Result(property="category.id", column="category_id"),
		@Result(property="category.category", column="category_name")
	})
	public List<Article> findAllFilter(@Param("filter") ArticleFilter filter, @Param("paging") Paging paging);
	
	@SelectProvider(method="countAllArticles", type=ArticleProvider.class)
	public Integer countAllArticles(ArticleFilter filter);
	
	
}











