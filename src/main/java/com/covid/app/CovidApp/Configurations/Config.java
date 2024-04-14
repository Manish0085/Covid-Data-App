package com.covid.app.CovidApp.Configurations;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class Config {


    @Bean
    public RestTemplate getInstance(){

        return new RestTemplate();
    }
}
