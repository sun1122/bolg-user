package com.zzu.spring.boot.blog.repository;

import java.util.List;

import com.zzu.spring.boot.blog.domain.User;

/**
  * UserRepository接口
  * 
  * @author 周家申
  * @date 2018年11月5日
  */
public interface UserRepository {
	
    /**
     * 创建或修改用户
     * @param user
     * @return
     */
	User saveorUpdateUser(User user);
	
	/**
	 *  删除用户
	 * @param id
	 * @return
	 */
	void deleteUser(Long id);
	
	User getUserByID(Long id);
	
	List<User> listUser();
	
}


