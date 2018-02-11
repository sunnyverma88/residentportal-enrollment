package org.residentportal.portal.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Comment {

	@Id
	@GeneratedValue
	private Integer commentId;
	
	@Column(name="comment_desc")
	private String commentDesc;
	
	@Column(name="published_date")
	private Date publishedDate;
	
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	
	@ManyToOne
	@JoinColumn(name="blogId")
	private Blog blog;


	public Integer getCommentId() {
		return commentId;
	}


	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Blog getBlog() {
		return blog;
	}


	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}


	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getCommentDesc() {
		return commentDesc;
	}


	public void setCommentDesc(String commentDesc) {
		this.commentDesc = commentDesc;
	}
	
	
	

	
	
	
}
