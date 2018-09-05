package com.qianyufeni.learnBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * @SpringBootApplication注解相当于使用@Configuration，@EnableAutoConfiguration和@ComponentScan和他们的默认属性
 */
@SpringBootApplication
public class LearnBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(LearnBootApplication.class, args);
	}
}
