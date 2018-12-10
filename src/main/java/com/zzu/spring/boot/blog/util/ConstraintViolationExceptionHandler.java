/**    
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author 周家申  
 * @date 2018年12月9日    
 */
package com.zzu.spring.boot.blog.util;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName: ConstraintViolationException Handler
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 周家申
 * @date 2018年12月9日
 * 
 */
public class ConstraintViolationExceptionHandler {
	/**
	 * 获取批量异常信息
	 * 
	 * @param e
	 * @return
	 */
	public static String getMessage(ConstraintViolationException e) {
		List<String> msgList = new ArrayList<>();
		for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
			msgList.add(constraintViolation.getMessage());
		}
		String messages = StringUtils.join(msgList.toArray(), ";");
		return messages;
	}
}
