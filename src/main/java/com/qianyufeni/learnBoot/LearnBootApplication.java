package com.qianyufeni.learnBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


/**
 * @SpringBootApplication注解相当于使用@Configuration，@EnableAutoConfiguration和@ComponentScan和他们的默认属性
 */
@EnableRedisHttpSession
@SpringBootApplication
public class LearnBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(LearnBootApplication.class, args);
	}
}
