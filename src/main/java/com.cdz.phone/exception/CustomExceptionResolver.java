package com.soa.mdm.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.soa.mdm.util.ResponseUtil;
/**
 * 
 * @author 曾兵
 * @company CDZ
 * @createTime 2017年10月22日下午12:39:19
 * @projectName ProjectForPhone
 * @className CustomExceptionResolver.java
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		// 定义异常输出
		JSONObject result = new JSONObject();
		// handler就是处理器适配器要执行Handler对象（只有一个method）
		// 解析出异常类型
		// 如果该异常类型是系统自定义的异常，直接取出异常信息，在错误页面展示
		CustomException customException = null;
		if (ex instanceof CustomException) {
			customException = (CustomException) ex;
		} else {
			customException = new CustomException("未知错误，请联系管理员！");
			// customException = new CustomException("未知错误");
		}
		String message = customException.getMessage();
		/*
		 * //输出作物信息到错误页面 ModelAndView mView=new ModelAndView();
		 * mView.addObject("message",message); mView.setViewName("error");
		 * return mView; request.setAttribute("errorInfo", message);
		 */
		result.put("status", "error");
		result.put("code", "-1");
		result.put("message", message);
		try {
			ResponseUtil.write(response, result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
