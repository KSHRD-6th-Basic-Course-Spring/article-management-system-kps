CREATE TABLE tb_categories (
	id INT primary key auto_increment,
	name varchar not null
);

CREATE TABLE tb_articles (
	id INT PRIMARY key auto_increment,
	title VARCHAR not null,
	description VARCHAR not null,
	thumbnail VARCHAR not null,
	author VARCHAR not null,
	created_date VARCHAR not null,
	category_id int REFERENCES tb_categories(id) on DELETE CASCADE on UPDATE CASCADE
);