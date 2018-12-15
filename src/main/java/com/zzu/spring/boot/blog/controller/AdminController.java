/**    
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author 周家申  
 * @date 2018年12月8日    
 */
package com.zzu.spring.boot.blog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zzu.spring.boot.blog.vo.Menu;

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
 
	/**
	 * 
	 * @Title: listUsers  
	 * @Description: TODO(动态获取菜单)  
	 * @param @param model
	 * @param @return    参数  
	 * @return ModelAndView    返回类型  
	 * @throws
	 */
	@GetMapping
    public ModelAndView listUsers(Model model) {
		//可以从数据库加载，目前先在内存中测试，后期改造
        List<Menu> list = new ArrayList<>();
        list.add(new Menu("用户管理", "/users"));
        model.addAttribute("list", list);
        return new ModelAndView("/admins/index", "model", model);
    }
}
