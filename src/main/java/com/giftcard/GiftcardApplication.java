package com.giftcard;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableAutoConfiguration
@SpringBootApplication
public class GiftcardApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(GiftcardApplication.class, args);
	}

	
}
