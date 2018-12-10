package com.zzu.spring.boot.blog.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * User实体类
 * 
 * @author 周家申
 * @date 2018年11月5日
 */
@Entity
public class User {

	// private static final long serialVersionUID = 4012253914345959363L;
	// 实体唯一标识
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// 用户名
	@NotEmpty(message = "姓名不能为空")
	@Size(min = 2, max = 20)
	@Column(nullable = false, length = 20) // 映射为字段，值不能为空
	private String name;
	// 邮箱地址

	@NotEmpty(message = "邮箱不能为空")
	@Size(max = 50)
	@Email(message = "邮箱格式不对")
	@Column(nullable = false, length = 50, unique = true)
	private String email;

	// 用户账号，登陆时的唯一标识
	@NotEmpty(message = "账号不能为空")
	@Size(min = 3, max = 20)
	@Column(nullable = false, length = 20, unique = true)
	private String username;

	// 用户密码
	@NotEmpty(message = "密码不能为空")
	@Size(max = 100)
	@Column(length = 100)
	private String passworld;

	// 头像图片地址
	@Column(length = 200)
	private String avatar;

	protected User() { // 防止直接使用
		super();
	}

	public User(Long id, String name, String username, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.username = username;
	}

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassworld() {
		return passworld;
	}

	public void setPassworld(String passworld) {
		this.passworld = passworld;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", username=" + username + ", passworld="
				+ passworld + ", avatar=" + avatar + "]";
	}

}
