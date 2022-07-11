package com.example.demo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo1Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

	
	@Value("${username}")
	String name;
	@Override
	public void run(String... args) throws Exception {
		System.out.println(name);
	}
}
