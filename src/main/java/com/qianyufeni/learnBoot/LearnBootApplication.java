package com.qianyufeni.learnBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
public class LearnBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnBootApplication.class, args);
	}
}
