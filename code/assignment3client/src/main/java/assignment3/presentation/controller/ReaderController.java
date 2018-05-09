package assignment3.presentation.controller;

import java.io.IOException;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import assignment3.communication.Client;
import assignment3.entities.Article;
import assignment3.presentation.view.ReaderView;

public class ReaderController {
	private ReaderView readerView;
	private Client client;

	public ReaderController(ReaderView readerView, Client client) {
		this.readerView = readerView;
		this.client = client;
		readerView.setArticlesListActionListener(new ArticleListSelectionListener());
	}

	public void createClient() {
		try {
			String res = client.communicate("view articles");
			List<Article> articles = readJSONList(res);
			for (Article a : articles) {
				readerView.getListModel().addElement(a.getArticleTitle());
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private class ArticleListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting()) {
				readerView.viewArticle();
				String selected = readerView.getArticleList().getSelectedValue();
				try {
					String res = client.communicate("open article", selected);
					Article article = readJSON(res);
					readerView.getArticleTextArea().append(article.getArticleTitle() + "\n"
							+ article.getArticleAbstract() + "\n" + article.getArticleBody());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				readerView.getViewArticleFrame().setVisible(true);
			}
		}
	}

	public Article readJSON(String jsonString) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Article article = mapper.readValue(jsonString, Article.class);
		return article;
	}

	public List<Article> readJSONList(String jsonString) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Article>> mapType = new TypeReference<List<Article>>() {
		};
		List<Article> jsonToArticleList = mapper.readValue(jsonString, mapType);
		return jsonToArticleList;
	}
}
