package com.github.iamhi.hizone.feedbackservice.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication(scanBasePackages = {"com.github.iamhi.hizone.feedbackservice"})
@EnableReactiveMongoRepositories("com.github.iamhi.hizone.feedbackservice.data")
@ConfigurationPropertiesScan("com.github.iamhi.hizone.feedbackservice.config")
public class FeedbackServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeedbackServiceApplication.class, args);
    }
}
