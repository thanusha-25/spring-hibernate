package com.jpa.StandardJPA.contents;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="student")
@Proxy(lazy=false)
public class Student {
	@Id
	@Column(name="id")
 private int id;
	@Column(name="name")
 private String name;
	@Column(name="email")
 private String email;
	public Student()
	{
		
	}
@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
public Student(int id, String name, String email) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
}
 
}
