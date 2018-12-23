package com.zzu.spring.boot.blog.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zzu.spring.boot.blog.domain.User;
import com.zzu.spring.boot.blog.service.UserService;
import com.zzu.spring.boot.blog.util.ConstraintViolationExceptionHandler;
import com.zzu.spring.boot.blog.vo.Response;

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
	//@Resource
	private UserService userService;

	/**
	 * 
	 * @Title: list  
	 * @Description: TODO(查询所有用户)  
	 * @param @param async
	 * @param @param pageIndex
	 * @param @param pageSize
	 * @param @param name
	 * @param @param model
	 * @param @return    参数  
	 * @return ModelAndView    返回类型  
	 * @throws
	 */
	   @GetMapping
	    public ModelAndView list(@RequestParam(value="async",required=false) boolean async,
	            @RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
	            @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
	            @RequestParam(value="name",required=false,defaultValue="") String name,
	            Model model) {

	        Pageable pageable = new PageRequest(pageIndex, pageSize);
	        Page<User> page = userService.listUsersByNameLike(name, pageable);
	        List<User> list = page.getContent();    // 当前所在页面数据列表

	        model.addAttribute("page", page);
	        model.addAttribute("userList", list);
	        return new ModelAndView(async==true?"users/list :: #mainContainerRepleace":"users/list", "userModel", model);
	    }

	/**
	 * 
	 * @Title: createForm  
	 * @Description: TODO(获取创建表单页面)  
	 * @param @param model
	 * @param @return    参数  
	 * @return ModelAndView    返回类型  
	 * @throws
	 */
	@GetMapping("/add")
    public ModelAndView createForm(Model model) {
        model.addAttribute("user", new User(null, null, null, null));
        return new ModelAndView("users/add", "userModel", model);
    }
	
	/**
	 * 
	 * @Title: saveOrUpateUser  
	 * @Description: TODO(保存或修改用戶)  
	 * @param @param user
	 * @param @return    参数  
	 * @return ResponseEntity<Response>    返回类型  
	 * @throws
	 */
	@PostMapping
    public ResponseEntity<Response> saveOrUpateUser(User user) {

        try {
            userService.saveOrUpateUser(user);
        }  catch (ConstraintViolationException e)  {
            return ResponseEntity.ok().body(new Response(false, ConstraintViolationExceptionHandler.getMessage(e)));
        }

        return ResponseEntity.ok().body(new Response(true, "处理成功", user));
    }
	/**
	 * 
	 * @Title: delete  
	 * @Description: TODO(删除用户)  
	 * @param @param id
	 * @param @param model
	 * @param @return    参数  
	 * @return ResponseEntity<Response>    返回类型  
	 * @throws
	 */
	@DeleteMapping(value = "/{id}")
    public ResponseEntity<Response> delete(@PathVariable("id") Long id, Model model) {
        try {
            userService.removeUser(id);
        } catch (Exception e) {
            return  ResponseEntity.ok().body( new Response(false, e.getMessage()));
        }
        return  ResponseEntity.ok().body( new Response(true, "处理成功"));
    }
	
	/**
	 * 
	 * @Title: modifyForm  
	 * @Description: TODO(获取修改用户的界面)  
	 * @param @param id
	 * @param @param model
	 * @param @return    参数  
	 * @return ModelAndView    返回类型  
	 * @throws
	 */
	@GetMapping(value = "edit/{id}")
    public ModelAndView modifyForm(@PathVariable("id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return new ModelAndView("users/edit", "userModel", model);
    }
}
