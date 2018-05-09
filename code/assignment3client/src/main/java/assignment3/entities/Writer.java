package assignment3.entities;

import java.util.List;

public class Writer {
	private Integer writerId;
	private String writerName;
	private String writerUsername;
	private String writerPassword;
	private List<Article> articles;

	public Writer() {
		super();
	}

	public Writer(String writerName, String writerUsername, String writerPassword) {
		super();
		this.writerName = writerName;
		this.writerUsername = writerUsername;
		this.writerPassword = writerPassword;
	}

	public Integer getWriterId() {
		return writerId;
	}

	public void setWriterId(Integer writerId) {
		this.writerId = writerId;
	}

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public String getWriterUserame() {
		return writerUsername;
	}

	public void setWriterUserame(String writerUsername) {
		this.writerUsername = writerUsername;
	}

	public String getWriterPassword() {
		return writerPassword;
	}

	public void setWriterPassword(String writerPassword) {
		this.writerPassword = writerPassword;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "Writer [writerId=" + writerId + ", writerName=" + writerName + ", writerUsername=" + writerUsername
				+ ", writerPassword=" + writerPassword + "]";
	}
}
