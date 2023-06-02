package dev.aquashdw.shoping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ShopingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopingApplication.class, args);
	}

}
