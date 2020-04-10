package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="userdetails")
public class UserDetails {
	
	
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	@Setter
	int userid;
	@Getter
	@Setter
	@Column(unique = true)
	String email;
	@Getter
	@Setter
	String name;
	@Getter
	@Setter
	String password;
	int age;
	@Getter
	@Setter
	String gender;
	@Getter
	@Setter
	String role;
	@Getter
	@Setter
	String phoneno;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
