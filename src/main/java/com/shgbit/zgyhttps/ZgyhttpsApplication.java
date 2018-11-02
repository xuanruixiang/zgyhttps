package com.shgbit.zgyhttps;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@MapperScan(basePackages="com.shgbit.zgyhttps.dao")
public class ZgyhttpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZgyhttpsApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
