package com.zzu.spring.boot.blog.vo;
/**  
 * @ClassName: Menu  
 * @Description: TODO(后台管理的菜单)  
 * @author 周家申  
 * @date 2018年12月11日  
 *    
 */
public class Menu {

	private String name; // 菜单名称
    private String url; // 菜单 URL
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Menu(String name, String url) {
		this.name = name;
		this.url = url;
	}
}


