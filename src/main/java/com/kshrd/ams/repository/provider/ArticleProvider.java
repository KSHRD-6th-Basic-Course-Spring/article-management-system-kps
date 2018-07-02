package com.kshrd.ams.repository.provider;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import com.kshrd.ams.model.ArticleFilter;
import com.kshrd.ams.utility.Paging;

public class ArticleProvider {

	public String findAllFilter(@Param("filter") ArticleFilter filter, @Param("paging") Paging paging) {
		return new SQL() {{
			SELECT("a.id, a.title, a.description, a.author, a.thumbnail, a.created_date, a.category_id, c.name as category_name");
			FROM("tb_articles a");
			INNER_JOIN("tb_categories c ON a.category_id=c.id");
			
			if (filter.getTitle() != null)
				WHERE("a.title ILIKE '%' || #{filter.title} || '%'");
			
			if (filter.getCate_id() != null)
				WHERE("a.category_id = #{filter.cate_id}");
			
			ORDER_BY("a.id DESC LIMIT #{paging.limit} OFFSET #{paging.offset}");
		}}.toString();
	}
	
	public String countAllArticles(ArticleFilter filter) {
		return new SQL() {{
			SELECT("COUNT(id)");
			FROM("tb_articles");
			if (filter.getTitle() != null)
				WHERE("title ILIKE '%' || #{title} || '%'");
			
			if (filter.getCate_id() != null)
				WHERE("category_id = #{cate_id}");
		}}.toString();
	}
	
}






