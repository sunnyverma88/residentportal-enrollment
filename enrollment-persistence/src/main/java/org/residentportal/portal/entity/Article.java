package org.residentportal.portal.entity;


import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Item
 *
 */
@Entity
public class Article {

	@Id
	@GeneratedValue
	private Integer itemId;
	
	private String title;
	private String description;	
	private String link;
	
	@Column(name="published_date")
	private Date publishedDate;
	
	@ManyToOne
	@JoinColumn(name="blogId")
	private Blog blog;
	
	
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	
   
}
