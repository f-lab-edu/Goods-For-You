package com.aorri2.goodsforyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GoodsForYouApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoodsForYouApplication.class, args);
	}

}
