package com.previred.manuelMarin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.previred.manuelMarin"})
@EntityScan("com.previred.manuelMarin")
@SpringBootApplication
public class ManuelMarinApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManuelMarinApplication.class, args);
	}

}
