package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;

@Controller
@MapperScan(basePackages="com.example.demo.mapper")
@SpringBootApplication
public class DemoApplication {

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Happy Coding!";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
