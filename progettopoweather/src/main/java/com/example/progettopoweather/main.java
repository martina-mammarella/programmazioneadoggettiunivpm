package com.example.progettopoweather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import  org.springframework.boot.SpringApplication ;
import  org.springframework.boot.autoconfigure.SpringBootApplication ;

@SpringBootApplication ( scanBasePackages = { "service ", " com.example.progettopoweather" , " model ","controller","filters","service" })
public class main {
	public static void main(String[] args) {
			SpringApplication.run(main.class, args);
		}

	}


