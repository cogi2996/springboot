package com.example.hello.config;

import com.example.hello.common.Coach;
import com.example.hello.common.SwimCoach;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration

public class SportConfig {
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
