package org.residentportal.portal.entity;

import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;


@Entity
public class Document {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;


	@Column(name="filename")
	private String filename;

	@Column(name="content")
	@Lob
	@Basic(fetch=FetchType.LAZY)
	private byte[] content;
	
	@Column(name="content_type")
	private String contentType;
	
	@Column(name="created")
	private Date created;
	
	@ManyToOne
	@JoinColumn(name="blogId")
	private Blog blog;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}