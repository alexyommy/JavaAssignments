package com.alexyom.firstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// 2. Importing dependencies
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
// 1. Annotation
@RestController
public class Application {
        public static void main(String[] args) {
                SpringApplication.run(Application.class, args);
        }
        
        // 1. Annotation
        @RequestMapping("/")
        // 3. Method that maps to the request route above
        public String hello() { // 3
                return "Hello client! How are you doing";
        }
        @RequestMapping("/random")
        // 3. Method that maps to the request route above
        public String random() { // 3
                return "Spring Boot! So easy to just respond with strings";
        }
}

