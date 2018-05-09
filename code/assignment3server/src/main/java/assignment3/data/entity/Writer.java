package assignment3.data.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "writers")
public class Writer {
	 @Id
	 @GeneratedValue( strategy = GenerationType.IDENTITY )
	 @Column
	 private Integer writerId;
	 @Column
	 private String writerName;
	 @Column
	 private String writerUsername;
	 @Column
	 private String writerPassword;
	 @OneToMany(mappedBy = "writer", fetch = FetchType.EAGER)
	 private List<Article> articles;
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
				+ ", writerPassword=" + writerPassword +"]";
	}
	 
}
