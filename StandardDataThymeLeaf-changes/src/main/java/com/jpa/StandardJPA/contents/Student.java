package com.jpa.StandardJPA.contents;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="student")
@Proxy(lazy=false)
@AllArgsConstructor 
@NoArgsConstructor
@Data
public class Student {
	@Id
	@Column(name="id")
 private int id;
	@Column(name="name")
 private String name;
	@Column(name="email")
 private String email;

}
