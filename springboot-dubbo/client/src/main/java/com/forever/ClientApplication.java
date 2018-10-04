package com.forever;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.forever.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableDubboConfiguration
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		//添加需要拦截的url
		List<String> urlPatterns = new ArrayList<>();
		urlPatterns.add("/*");
		registrationBean.addUrlPatterns(urlPatterns.toArray(new String[urlPatterns.size()]));
		return registrationBean;
	}
}
