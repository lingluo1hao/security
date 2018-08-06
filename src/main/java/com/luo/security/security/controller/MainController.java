/**
 * 
 */
package com.luo.security.security.controller;

import com.luo.security.security.entity.sUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Main Controller.
 * 
 * @since 1.0.0 2017年7月26日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@Controller
public class MainController {
	
	@GetMapping("/")
	public String root() {
		return "redirect:/index";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}


	@RequestMapping("/hello")
	public String hello() {
		SecurityContext ctx   =   SecurityContextHolder.getContext();
		Authentication auth   =   ctx.getAuthentication();
		if(auth.getPrincipal()   instanceof UserDetails)
		{
			sUser user   =   (sUser)auth.getPrincipal();
			System.out.println(user.getEmail());
		}
		//本段代码演示如何获取登录的用户资料

		return "hello";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		model.addAttribute("errorMsg", "登陆失败，用户名或者密码错误！");
		return "login";
	}

}