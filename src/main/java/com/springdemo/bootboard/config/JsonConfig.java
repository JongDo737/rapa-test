//package com.springdemo.bootboard.config;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.module.SimpleModule;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//
//@Configuration
//public class JsonConfig {
//    @Bean
//    public ObjectMapper objectMapper() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        SimpleModule module = new SimpleModule();
//        // CustomUsernamePasswordAuthenticationTokenDeserializer를 여기에 등록
//        module.addDeserializer(UsernamePasswordAuthenticationToken.class, new CustomUsernamePasswordAuthenticationTokenDeserializer());
//        objectMapper.registerModule(module);
//        return objectMapper;
//
//    }
//}
