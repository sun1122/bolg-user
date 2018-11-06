package com.zzu.spring.boot.blog.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.zzu.spring.boot.blog.domain.User;

/**
 * UserRepositoryImpl
 * 
 * @author 周家申
 * @date 2018年11月5日
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
	private static AtomicLong counter = new AtomicLong();
	private final ConcurrentHashMap<Long, User> userMap = new ConcurrentHashMap<>();

	@Override
	public User saveorUpdateUser(User user) {
		Long id = user.getId();
		// 新建用户时
		if (id == null) {
			id = counter.incrementAndGet();
			user.setId(id);
		}
		this.userMap.put(id, user);
		return user;
	}

	@Override
	public void deleteUser(Long id) {

		this.userMap.remove(id);
	}

	@Override
	public User getUserByID(Long id) {

		return this.userMap.get(id);
	}

	@Override
	public List<User> listUser() {
		
		//return (ArrayList<User>) this.userMap.values();
		return new ArrayList<User>(this.userMap.values());
	}

}
