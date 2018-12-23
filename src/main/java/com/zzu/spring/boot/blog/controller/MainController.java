/**    
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author 周家申  
 * @date 2018年12月8日    
 */
package com.zzu.spring.boot.blog.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.zzu.spring.boot.blog.domain.User;
import com.zzu.spring.boot.blog.service.UserService;

/**
 * @ClassName: MainController
 * @Description: TODO(主页控制器)
 * @author 周家申
 * @date 2018年12月8日
 * 
 */
@Controller
public class MainController {
	
	//@Resource
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String root() {
		return "redirect:/index";// 重定向 地址变，重新发请求
	}

	@GetMapping("/index")
	public String index() {

		return "index";
	}
	
	@GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        model.addAttribute("errorMsg", "登陆失败，用户名或者密码错误！");
        return "login";
    }
    
    @GetMapping("/register")
    public String register() {
    	return "register";
    }
    
    @PostMapping("/register")
    public String registerUser(User user) {
        userService.registerUser(user);
        return "redirect:/login";//注册成功返回到登陆页面
    }

}
