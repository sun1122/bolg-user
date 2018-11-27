package com.zzu.spring.boot.blog.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
  * User实体类
  * 
  * @author 周家申
  * @date 2018年11月5日
  */
@Entity
public class User {
    
	//private static final long serialVersionUID = 4012253914345959363L;
	//实体唯一标识
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//用户名
	private String name;
	//邮箱地址
	private String email;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	protected User() { //防止直接使用
		super();
	}
	public User(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
	
	
}


