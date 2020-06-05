package com.example.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * /playlist/** 요청에 대해 적용되는 인터셉터.
 * 
 */
public class PlaylistInterceptor extends HandlerInterceptorAdapter {

	/**
	 * /playlist/** 요청일 
	 * hearder.Authorization의 값이 LOGGED_IN이 아니면 리다이렉트 시킨다. 
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		if (!"LOGGED_IN".equals(request.getHeader("Authorization"))) {
			response.sendRedirect("/login/invalid");
			return false;
		}

		return true;
	}

}
