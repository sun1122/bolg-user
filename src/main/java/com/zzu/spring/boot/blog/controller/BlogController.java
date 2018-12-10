/**    
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author 周家申  
 * @date 2018年12月8日    
 */
package com.zzu.spring.boot.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName: BlogController
 * @Description: TODO(博客控制器)
 * @author 周家申
 * @date 2018年12月8日
 * 
 */
@Controller
@RequestMapping("/blogs")
public class BlogController {

	/**
	 * 
	 * @Title: listBlogs  
	 * @Description: TODO(博客列表)  
	 * @param @param order   排序列表规则默认是最新排序
	 * @param @param keyword 关键字
	 * @param @return    参数  
	 * @return String    返回类型  
	 * @throws
	 */
	@GetMapping
	public String listBlogs(@RequestParam(value="order",required=false,defaultValue="new") String order,
			@RequestParam(value="keyword",required=false,defaultValue="" ) String keyword){
		System.out.println("order:" +order + ";keyword:" +keyword );
		//重定向时带着参数
		return "redirect:/index?order="+order+"&keyword="+keyword;
	}

}
