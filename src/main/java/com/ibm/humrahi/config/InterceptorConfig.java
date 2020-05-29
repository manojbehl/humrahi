package com.ibm.humrahi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter{

	@Autowired
	AutheticationInterceptor securityInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.err.println("inter");

		registry.addInterceptor(securityInterceptor).addPathPatterns("/**").excludePathPatterns("/forgot/password**",
				"/api/signup", "/resend/otp","/h2/login**", "/qrcode/**","/generateOTP/**", "/swagger**/**", "/swagger-ui.html", "/webjars/**", "/v2/api-docs", "/user/create");
	}
}
