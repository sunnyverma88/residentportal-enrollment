package org.residentportal.portal.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.residentportal.portal.annotation.UniqueEmail;


@Entity
@Table(name = "App_User")
public class User {

@Id
@GeneratedValue
private Integer userId;

@Size(min=3, message="Name atleast 3 characters")
private String name;

@Email
@Column(unique=true)
@UniqueEmail(message="This Email already Exists in our database")
private String email;

@Size(min=5, message="Password atleast 5 characters")
private String password;
private String userUrl;
private boolean enabled;

@ManyToMany
@JoinTable(name="User_Role", joinColumns=@JoinColumn(name="User_ID"))
private List<Role> roles;

@OneToMany(mappedBy="user" , cascade=CascadeType.REMOVE)
private List<Blog> blogs;

@OneToMany(mappedBy="user" , cascade=CascadeType.REMOVE)
private List<Comment> comments;

@OneToMany(mappedBy="user" , cascade=CascadeType.REMOVE)
private List<Document> documents;


public List<Blog> getBlogs() {
	return blogs;
}

public void setBlogs(List<Blog> blogs) {
	this.blogs = blogs;
}

public List<Role> getRoles() {
	return roles;
}

public void setRoles(List<Role> roles) {
	this.roles = roles;
}

public Integer getUserId() {
	return userId;
}

public void setUserId(Integer userId) {
	this.userId = userId;
}



public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public boolean isEnabled() {
	return enabled;
}

public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}

public String getUserUrl() {
	return userUrl;
}

public void setUserUrl(String userUrl) {
	this.userUrl = userUrl;
}

public List<Comment> getComments() {
	return comments;
}

public void setComments(List<Comment> comments) {
	this.comments = comments;
}

public List<Document> getDocuments() {
	return documents;
}

public void setDocuments(List<Document> documents) {
	this.documents = documents;
}


}
