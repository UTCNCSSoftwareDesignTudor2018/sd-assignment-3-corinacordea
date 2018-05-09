package assignment3.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import assignment3.data.entity.Article;

public interface ArticleJpaRepository extends JpaRepository<Article,Integer>{
	public Article findArticleByArticleTitle(String title);
}
