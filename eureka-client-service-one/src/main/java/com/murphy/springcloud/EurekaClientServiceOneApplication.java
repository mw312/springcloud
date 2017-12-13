package com.murphy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author momo
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaClientServiceOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientServiceOneApplication.class, args);
	}
}
