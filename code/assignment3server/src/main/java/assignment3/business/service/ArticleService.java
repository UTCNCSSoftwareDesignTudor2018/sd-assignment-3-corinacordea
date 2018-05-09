package assignment3.business.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import assignment3.data.entity.Article;
import assignment3.data.repository.ArticleJpaRepository;
import assignment3.data.repository.WriterJpaRepository;

@Service
public class ArticleService {
	@Autowired 
	ArticleJpaRepository articleRepository;
	@Autowired 
	WriterJpaRepository writerRepository;
	@Autowired
	ArticleService articleService;
	public String findAll() throws JsonGenerationException, JsonMappingException, IOException {
		List<Article> articles = articleRepository.findAll(); ;
		return  writeListToJSON(articles);
	}
	public String getArticle(String title) throws JsonGenerationException, JsonMappingException, IOException {
		Article article = articleRepository.findArticleByArticleTitle(title); 
		return  writeJSON(article);
	}
	public void saveArticle(String articleData, String writerData) throws JsonParseException, JsonMappingException, IOException {
		Article article = readJSON(articleData);
		article.setWriter(writerRepository.findByWriterId(Integer.parseInt(writerData)));
		articleRepository.save(article);
	}
	public Article readJSON(String jsonString) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Article article = mapper.readValue(jsonString, Article.class);
		return article;
	}
	public String writeJSON(Article article) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(article);
		return result;
	}
	public String writeListToJSON(List<Article> articles) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(articles);
		return result;
	}
}
