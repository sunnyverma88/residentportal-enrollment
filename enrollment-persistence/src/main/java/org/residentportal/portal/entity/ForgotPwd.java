package org.residentportal.portal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;
import org.residentportal.portal.annotation.UniqueEmail;

@Entity
public class ForgotPwd {

	@Id
	@GeneratedValue
	int requestId;
	
	@Email
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
