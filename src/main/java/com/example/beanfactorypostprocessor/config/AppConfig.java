package com.example.beanfactorypostprocessor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com")
public class AppConfig {

    //some other breans...
    //Since I want this bean to start first I make this bean as static

    @Bean
    public static CustomBeanFactoryPostProcessor beanFactoryPostProcessor(){
        return new CustomBeanFactoryPostProcessor();
    }
}
