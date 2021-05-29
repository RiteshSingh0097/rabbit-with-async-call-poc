package com.ritesh.fetch;

import com.ritesh.EnableCommon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ritesh")
@ComponentScan(basePackageClasses = EnableCommon.class)
public class FetchApplication {

	public static void main(String[] args) {
		SpringApplication.run(FetchApplication.class, args);
	}

}
