package com.luo.security.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello 控制器.
 * 
 * @since 1.0.0 2017年7月1日
 */
@RestController
public class HelloController {

	@RequestMapping("/hello1")
	public String hello() {
	    return "Hello World! Welcome to visit waylau.com!";
	}
}
