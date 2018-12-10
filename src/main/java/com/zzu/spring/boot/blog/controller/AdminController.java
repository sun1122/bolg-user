/**    
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author 周家申  
 * @date 2018年12月8日    
 */
package com.zzu.spring.boot.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: AdminController
 * @Description: TODO(后台管理控制器)
 * @author 周家申
 * @date 2018年12月8日
 * 
 */
@Controller
@RequestMapping("/admins")
public class AdminController {
 
	@GetMapping
	public ModelAndView listUsers(Model model) {
		return new ModelAndView("admins/index", "menuList", model);
	}
}
