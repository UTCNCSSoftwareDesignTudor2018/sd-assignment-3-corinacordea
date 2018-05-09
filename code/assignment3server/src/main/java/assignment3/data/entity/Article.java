package assignment3.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "articles")
public class Article {
	 @Id
	 @GeneratedValue( strategy = GenerationType.IDENTITY )
	 @Column
	 private Integer articleId;
	 @Column
	 private String articleTitle;
	 @Column
	 private String articleAbstract;
	 @ManyToOne
	 @JoinColumn(name = "writer_id")
	 @JsonIgnore
	 private Writer writer;
	 @Column
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
