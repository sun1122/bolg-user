package com.zzu.spring.boot.blog.vo;
/**  
 * @ClassName: Response  
 * @Description: TODO(返回对象    值对象或者页面对象  一般用于web层向view层封装并提供需要展现的数据)  
 * @author 周家申  
 * @date 2018年12月9日  
 *    
 */
public class Response {
	private boolean success; // 处理是否成功
    private String message; // 处理后消息提示
    private Object body; // 返回数据
    
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
	
    public Response(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Response(boolean success, String message, Object body) {
        this.success = success;
        this.message = message;
        this.body = body;
    }
}


