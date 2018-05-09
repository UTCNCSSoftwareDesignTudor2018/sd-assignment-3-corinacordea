package assignment3.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import assignment3.communication.Client;
import assignment3.entities.Article;
import assignment3.entities.Writer;
import assignment3.presentation.view.WriterView;

public class WriterController {
	private WriterView writerView;
	private Client client;
	private Writer writer;
	public WriterController(WriterView writerView, Client client) {
			this.writerView = writerView;
			this.client = client;
			writerView.setArticlesListActionListener(new ArticleListSelectionListener());
			writerView.setViewButtonActionListener(new ViewButtonActionListener());
			writerView.setSaveDataButtonActionListener(new SaveDataButtonActionListener());
			writerView.setUpdateButtonActionListener(new UpdateButtonActionListener());
			writerView.setUpdateDataButtonActionListener(new UpdateDataButtonActionListener());
			writerView.setDeleteButtonActionListener(new DeleteButtonActionListener());
			writerView.setWriteButtonActionListener(new WriteButtonActionListener());
			writerView.setSaveArticleButtonActionListener(new SaveArticleButtonActionListener());
		}

	public String createClient(String username, String password) {
		try {
			String res = client.communicate("writer authentication", username, password);
			writer = readJSON(res);
			if (writer != null) {
				return "success";
			} else {
				return "fail";
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	private class SaveDataButtonActionListener implements ActionListener {
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent event) {
			try {
				Writer writer = new Writer(writerView.getWriterNameTextField().getText(),
						writerView.getUsernameTextField().getText(),
						writerView.getPasswordTextField().getText());
				client.communicate("create account", writeJSON(writer));
			} catch (IOException e) {
				e.printStackTrace();
			}
			writerView.getAccountFrame().dispose();
		}
	}
		
	private class ViewButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			writerView.viewArticle();
			writerView.getListModel().removeAllElements();
			try {
				String res = client.communicate("view articles");
				List<Article> articles = readArticleJSONList(res);
				for (Article a : articles) {
					writerView.getListModel().addElement(a.getArticleTitle());
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			writerView.getViewFrame().setVisible(true);
		}
	}
	
	private class ArticleListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting()) {
				writerView.viewArticleContent();
				String selected = writerView.getArticleList().getSelectedValue();
				try {
					String res = client.communicate("open article", selected);
					Article article = readArticleJSON(res);
					writerView.getArticleTextArea().append(article.getArticleTitle() + "\n"
							+ article.getArticleAbstract() + "\n" + article.getArticleBody());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				writerView.getViewArticleFrame().setVisible(true);
			}
		}
	}
	
	private class UpdateButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			writerView.updateAccount();
			writerView.getWriterNameTextField().setText(writer.getWriterName());
			writerView.getUsernameTextField().setText(writer.getWriterUserame());
			writerView.getPasswordTextField().setText(writer.getWriterPassword());
			writerView.getUpdateFrame().setVisible(true);
		}
	}
	
	private class UpdateDataButtonActionListener implements ActionListener {
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent event) {
			try {
				writer.setWriterName(writerView.getWriterNameTextField().getText());
				writer.setWriterUserame(writerView.getUsernameTextField().getText());
				writer.setWriterPassword(writerView.getPasswordTextField().getText());
				client.communicate("update account", writeJSON(writer));
			} catch (IOException e) {
				e.printStackTrace();
			}
			writerView.getUpdateFrame().dispose();
		}
	}
	
	private class WriteButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			writerView.writeArticle();
			writerView.getListModel().removeAllElements();
			writerView.getArticleTitleTextArea().setText("");
			writerView.getArticleAbstractTextArea().setText("");
			writerView.getArticleBodyTextArea().setText("");
			try {
				String res = client.communicate("view articles");
				List<Article> articles = readArticleJSONList(res);
				for (Article a : articles) {
					writerView.getListModel().addElement(a.getArticleTitle());
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			writerView.getWriteFrame().setVisible(true);
		}
	}
	
	private class SaveArticleButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			Article article = new Article();
			article.setArticleTitle(writerView.getArticleTitleTextArea().getText());
			article.setArticleAbstract(writerView.getArticleAbstractTextArea().getText());
			article.setArticleBody(writerView.getArticleBodyTextArea().getText());
			try {
				client.communicate("write article", writeArticleJSON(article),writer.getWriterId().toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
			writerView.getWriteFrame().dispose();
		}
	}
	
	private class DeleteButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			int option = JOptionPane.showConfirmDialog(writerView.getWriterPanel(), "Are you sure you want to delete your account?", "Confirm delete", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if(option == JOptionPane.OK_OPTION) {
				try {
					client.communicate("delete account", writer.getWriterId().toString());
					writerView.getWriterFrame().dispose();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public String writeJSON(Writer writer) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(writer);
		return result;
	}
	public String writeArticleJSON(Article article) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(article);
		return result;
	}
	public Article readArticleJSON(String jsonString) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Article article = mapper.readValue(jsonString, Article.class);
		return article;
	}
	
	public List<Article> readArticleJSONList(String jsonString) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Article>> mapType = new TypeReference<List<Article>>() {
		};
		List<Article> jsonToArticleList = mapper.readValue(jsonString, mapType);
		return jsonToArticleList;
	}
	
	public Writer readJSON(String jsonString) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Writer writer = mapper.readValue(jsonString, Writer.class);
		return writer;
	}

	public List<Writer> readJSONList(String jsonString) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Writer>> mapType = new TypeReference<List<Writer>>() {
		};
		List<Writer> jsonToArticleList = mapper.readValue(jsonString, mapType);
		return jsonToArticleList;
	}
}
