package com.school;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.school.dao")
@SpringBootApplication
public class GraduationApplication {
	public static void main(String[] args) {
		SpringApplication.run(GraduationApplication.class, args);
	}
}
