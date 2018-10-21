package com.zthulj.blog.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@ComponentScan("com.zthulj.blog")
@EnableMongoRepositories("com.zthulj.blog.repository")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        BCryptPasswordEncoder p = new BCryptPasswordEncoder();
        System.out.println(p.encode("clientid"));
    }
}
