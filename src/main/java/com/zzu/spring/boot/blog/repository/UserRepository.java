package com.zzu.spring.boot.blog.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.zzu.spring.boot.blog.domain.User;

/**
 * UserRepository接口
 * 
 * @author 周家申
 * @date 2018年11月5日
 */
public interface UserRepository extends CrudRepository<User, Long> {

}
