package com.codetest.usermgmnt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String userId;
	
	@Column(name="name",length=50)
	private String name;
	
	@Column(name="email",length=100)
	private String email;
	
	@Column(name="pincode",length=8)
	private String pincode;
	
	public User() {	
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email
				+ ", pincode=" + pincode + "]";
	}

}
