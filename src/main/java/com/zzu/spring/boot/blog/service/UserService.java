package com.zzu.spring.boot.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.zzu.spring.boot.blog.domain.User;

/**
 * @ClassName: UserService
 * @Description: TODO(用户服务接口)
 * @author 周家申
 * @date 2018年12月9日
 * 
 */
public interface UserService {
	/**
	 * 新增、编辑、保存用户
	 * 
	 * @param user
	 * @return
	 */
	User saveOrUpateUser(User user);

	/**
	 * 注册用户
	 * 
	 * @param user
	 * @return
	 */
	User registerUser(User user);

	/**
	 * 删除用户
	 * 
	 * @param user
	 * @return
	 */
	void removeUser(Long id);

	/**
	 * 根据id获取用户
	 * 
	 * @param user
	 * @return
	 */
	User getUserById(Long id);

	/**
	 * 根据用户名进行分页模糊查询
	 * 
	 * @param user
	 * @return
	 */
	Page<User> listUsersByNameLike(String name, Pageable pageable);
}
