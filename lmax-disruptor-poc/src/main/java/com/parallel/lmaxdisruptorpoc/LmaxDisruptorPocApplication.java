package com.parallel.lmaxdisruptorpoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan(basePackages = { "com.parallel.*" })
@EnableScheduling
@SpringBootApplication
public class LmaxDisruptorPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmaxDisruptorPocApplication.class, args);
	}

}
