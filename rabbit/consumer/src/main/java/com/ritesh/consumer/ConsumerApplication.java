package com.ritesh.consumer;

import com.ritesh.EnableCommon;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableRabbit
@EnableAsync
@SpringBootApplication
@ComponentScan(basePackages = "com.ritesh")
@ComponentScan(basePackageClasses = EnableCommon.class)
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

}
