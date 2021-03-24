package com.example.demo.config;

import com.example.demo.model.StudentValidator;
import com.example.demo.model.StudentValidatorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentValidatorConfig {
    @Bean
    public StudentValidator studentValidator(){
        return new StudentValidatorImpl();
    }
}
