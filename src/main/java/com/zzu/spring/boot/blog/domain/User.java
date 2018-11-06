package com.zzu.spring.boot.blog.domain;
/**
  * User实体类
  * 
  * @author 周家申
  * @date 2018年11月5日
  */
public class User {
    //实体唯一标识
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
	public User() {
		super();
	}
	public User(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	
	
}


