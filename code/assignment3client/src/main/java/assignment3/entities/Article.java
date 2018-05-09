package assignment3.entities;

public class Article {
	 private Integer articleId;
	 private String articleTitle;
	 private String articleAbstract;
	 private Writer writer;
	 private String articleBody;
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public String getArticleAbstract() {
		return articleAbstract;
	}
	public void setArticleAbstract(String articleAbstract) {
		this.articleAbstract = articleAbstract;
	}
	public Writer getWriter() {
		return writer;
	}
	public void setWriter(Writer writer) {
		this.writer = writer;
	}
	public String getArticleBody() {
		return articleBody;
	}
	public void setArticleBody(String articleBody) {
		this.articleBody = articleBody;
	}
	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", articleTitle=" + articleTitle + ", articleAbstract="
				+ articleAbstract + ", writerId=" + writer.getWriterId() + ", articleBody=" + articleBody + "]";
	}

}
