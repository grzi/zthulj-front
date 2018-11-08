package com.zthulj.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan({"com.zthulj.blog.config", "com.zthulj.blog.repository", "com.zthulj.blog.service", "com.zthulj.blog.api"})
@EnableMongoRepositories("com.zthulj.blog.repository")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
