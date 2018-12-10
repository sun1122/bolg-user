package com.zzu.spring.boot.blog.service.impl;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzu.spring.boot.blog.domain.User;
import com.zzu.spring.boot.blog.repository.UserRepository;
import com.zzu.spring.boot.blog.service.UserService;

/**  
 * @ClassName: UserServiceImpl  
 * @Description: TODO(用户服务接口实现)  
 * @author 周家申  
 * @date 2018年12月9日  
 *    
 */
@Service
public class UserServiceImpl implements UserService {

	//dao层注入
	@Resource// id
	private UserRepository userRepository;
	/**
	 * <p>Title: saveOrUpateUser</p>  
	 * <p>Description: </p>  
	 * @param user
	 * @return    
	 */
	@Transactional//使用事务
	@Override
	public User saveOrUpateUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	/**
	 * <p>Title: registerUser</p>  
	 * <p>Description: </p>  
	 * @param user
	 * @return    
	 */
	@Transactional
	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	/**
	 * <p>Title: removeUser</p>  
	 * <p>Description: </p>  
	 * @param id    
	 */
	@Transactional
	@Override
	public void removeUser(Long id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);
	}

	/**
	 * <p>Title: getUserById</p>  
	 * <p>Description: </p>  
	 * @param id
	 * @return    
	 */
	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	/**
	 * <p>Title: listUsersByNameLike</p>  
	 * <p>Description: </p>  
	 * @param name
	 * @param pageable
	 * @return    
	 */
	@Override
	public Page<User> listUsersByNameLike(String name, Pageable pageable) {
		// TODO Auto-generated method stub
		//模糊查询
		return userRepository.findByNameLike("%"+name+"%", pageable);
	}

}


