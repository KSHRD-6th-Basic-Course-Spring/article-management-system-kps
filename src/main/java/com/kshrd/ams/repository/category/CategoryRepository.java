package com.kshrd.ams.repository.category;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.kshrd.ams.model.Category;

@Repository
public interface CategoryRepository {
	
	@Select("SELECT * FROM tb_categories")
	@Results({
		@Result(property="category", column="name")
	})
	public List<Category> findAll();
	
	@Select("SELECT * FROM tb_categories WHERE id=#{id}")
	@Results({
		@Result(property="category", column="name")
	})
	public Category findOne(int id);
	
}
