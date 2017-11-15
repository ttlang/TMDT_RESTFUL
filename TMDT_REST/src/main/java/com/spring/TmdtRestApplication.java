package com.spring;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableJSONDoc
public class TmdtRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmdtRestApplication.class, args);
	}
}
