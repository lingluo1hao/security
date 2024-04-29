
package com.luo.security.security.config;

import com.luo.security.security.handler.LoginSuccessHandler;
import com.luo.security.security.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 安全配置类.
 * 
 * @since 1.0.0 2017年7月25日
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private CustomUserDetailsService customUserDetailsService;




	/**
	 * 自定义配置
	 */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	/*
    	http.authorizeRequests()
    		.antMatchers("/css/**", "/js/**", "/fonts/**", "/index").permitAll() // 都可以访问
    		.antMatchers("/users/**").hasRole("ADMIN")   // 需要相应的角色才能访问
			.and()
			.formLogin()   //基于 Form 表单登录验证
			.loginPage("/login").failureUrl("/login-error"); // 自定义登录界面
			*/

		//允许所有用户访问”/”和”/home”
		http.authorizeRequests().antMatchers("/", "/home").permitAll()
				.antMatchers("/hello").hasAuthority("ADMIN")
				//其他地址的访问均需验证权限
				.anyRequest().authenticated()
				.and()
				.formLogin()
				//指定登录页是”/login”
				.loginPage("/login")
				.permitAll()
				//登录成功后可使用loginSuccessHandler()存储用户信息，可选。
				.successHandler(loginSuccessHandler())
				.and()
				.logout()
//退出登录后的默认网址是”/home”
				.logoutSuccessUrl("/home")
				.permitAll()
				.invalidateHttpSession(true)
				.and()
				//登录后记住用户，下次自动登录
				//数据库中必须存在名为persistent_logins的表
				//建表语句见code15
				.rememberMe()
				.tokenValiditySeconds(1209600);


	}
 
    /**
     * 认证信息管理
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {


//指定密码加密所使用的加密器为passwordEncoder()
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
//不删除凭据，以便记住用户
		auth.eraseCredentials(false);


	}



	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(4);
	}


	@Bean
	public LoginSuccessHandler loginSuccessHandler(){
		return new LoginSuccessHandler();
	}


}
