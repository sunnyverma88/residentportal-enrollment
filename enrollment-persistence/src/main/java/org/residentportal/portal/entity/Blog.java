package org.residentportal.portal.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.URL;

/**
 * Entity implementation class for Entity: Blog
 *
 */
@Entity
public class Blog {

	@Id
	@GeneratedValue
	private Integer blogId;
	
	@Size(min=3, message="Name atleast 3 characters")
	private String name;
	
	@URL
	private String url;
	
	@URL
	private String vurl;
	
	private boolean isApproved;
    @Lob
    @Type(type="org.hibernate.type.MaterializedClobType")
	private String description;
    
	@Column(name="published_date")
	private Date publishedDate;
	
	private String category;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="blog" , cascade=CascadeType.REMOVE)
	private List<Comment> comments;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="blog" , cascade=CascadeType.REMOVE)
	private List<Document> documents;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Integer getBlogId() {
		return blogId;
	}
	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	public boolean isApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	public String getVurl() {
		return vurl;
	}
	public void setVurl(String vurl) {
		this.vurl = vurl;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<Document> getDocuments() {
		return documents;
	}
	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}
	
	
	
   
}