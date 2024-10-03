package com.proyecto.crud.RestTempl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfiguracionBean {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
