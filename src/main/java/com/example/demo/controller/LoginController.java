package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.util.ResponseMapper;

@RequestMapping("/login")
@RestController
public class LoginController {

	/**
	 * GET /login/invalid
	 * 권한이 필요한 서비스 (/playlist를 권한 없이 요청했을 때 리다이렉트하여 에러처리함. 
	 */
	@GetMapping("/invalid")
	public ResponseEntity<Object> authoricationFail() {
		return ResponseMapper.errorResponse(HttpStatus.UNAUTHORIZED.value());
	}
}
