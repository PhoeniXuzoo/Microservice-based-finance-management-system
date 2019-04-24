package cn.phoenixuzoo.oauth2service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class Oauth2serviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2serviceApplication.class, args);
	}

}
