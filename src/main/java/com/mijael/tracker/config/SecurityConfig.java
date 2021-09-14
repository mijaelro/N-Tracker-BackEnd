package com.mijael.tracker.config;

import com.mijael.tracker.security.Information;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SecurityConfig {

    @Bean
    public Map<String, Information> map (){
        return new HashMap<>();
    }
}
