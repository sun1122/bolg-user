package com.zzu.spring.boot.blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.zzu.spring.boot.blog.domain.User;

/**
 * UserRepository接口  分页JpaRepository
 * 
 * @author 周家申
 * @date 2018年11月5日
 */
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * 
	 * @Title: findByNameLike  
	 * @Description: TODO(根据用户姓名分页查询用户列表)  
	 * @param @param name
	 * @param @param pageable
	 * @param @return    参数  
	 * @return Page<User>    返回类型  
	 * @throws
	 */
	Page<User> findByNameLike(String name, Pageable pageable);
	
	/**
	 * 
	 * @Title: findByUserName  
	 * @Description: TODO(根据用户账号查询用户)  
	 * @param @param username
	 * @param @return    参数  
	 * @return User    返回类型  
	 * @throws
	 */
	User findByUserName(String username);
}
