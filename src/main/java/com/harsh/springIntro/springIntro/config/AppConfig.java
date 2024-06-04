package com.harsh.springIntro.springIntro.config;

import com.harsh.springIntro.springIntro.DB;
import com.harsh.springIntro.springIntro.DevDB;
import com.harsh.springIntro.springIntro.ProdDB;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// To supply objects
@Configuration
public class AppConfig {

    @Bean
    @ConditionalOnProperty(name= "project.mode", havingValue = "development")
    public DB getDevDBBean(){
        return new DevDB();
    }

    @Bean
    @ConditionalOnProperty(name= "project.mode", havingValue = "production")
    public DB getDevProdBean(){
        return new ProdDB();
    }
}