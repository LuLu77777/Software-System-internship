package com.example.secondwebexperiment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.example.secondwebexperiment.mapper")
@EnableTransactionManagement
public class SecondwebexperimentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondwebexperimentApplication.class, args);
	}

}
