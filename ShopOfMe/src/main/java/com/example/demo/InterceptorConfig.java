package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.interceptor.GlobalIntelceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
@Autowired
GlobalIntelceptor globalIntelceptor;

@Override
	public void addInterceptors(InterceptorRegistry registry) {
	registry.addInterceptor(globalIntelceptor)
	.addPathPatterns("/**")
	.excludePathPatterns("/rest/**","/admin/**","/assets/**");
	}
}
