package com.zzu.spring.boot.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zzu.spring.boot.blog.domain.User;
import com.zzu.spring.boot.blog.repository.UserRepository;

/**
 * UserController
 * 
 * @author 周家申
 * @date 2018年11月5日
 */
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	/**
	 * 查询用户列表
	 * 
	 * @param mo
	 * @return
	 */
	// @RequestMapping(method=RequestMethod.GET)
	@GetMapping
	public ModelAndView listUser(Model mo) {
		mo.addAttribute("userList", userRepository.listUser());
		mo.addAttribute("title", "用户管理");
		return new ModelAndView("users/list", "userModel", mo);
	}

	/**
	 * 根据用户id查询用户
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", userRepository.getUserByID(id));
		model.addAttribute("title", "查看用户");
		return new ModelAndView("users/view", "userModel", model);
	}

	/**
	 * 创建表单页面
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/form")
	public ModelAndView certeForms(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("title", "创建用户");
		return new ModelAndView("users/form", "userModel", model);
	}
    /**
     * 新建用户
     * @param user
     * @return
     */
	@PostMapping
	public ModelAndView certe(User user) {
		user = userRepository.saveorUpdateUser(user);
		return new ModelAndView("redirect:/users");//重定向list
	}

	/**
	 * 根据id删除用户
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id, Model model) {
		userRepository.deleteUser(id);
		return new ModelAndView("redirect:/users");//重定向list
	}
	
	
	/**
	 * 根据id修改用户
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/modify/{id}")
	public ModelAndView modify(@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("user", userRepository.getUserByID(id));
		model.addAttribute("title", "修改用户");
		return new ModelAndView("users/form", "userModel", model);
	}
	
}
