package com.example.postmessageservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ComponentScan("com.example.postmessageservice.messagerepository")
@SpringBootApplication
public class PostMessageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostMessageServiceApplication.class, args);
        System.out.println("Hello PMS");

    }

}
