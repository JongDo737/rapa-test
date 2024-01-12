package com.springdemo.bootboard.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Configuration
@EnableRedisHttpSession
public class RedisConfig{

    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private int redisPort;

    @Value("${spring.redis.password}")
    private String redisPassword;
//    @Bean
//    public RedisSerializer<Object> springSessionDefaultRedisSerializer() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        SimpleModule module = new SimpleModule();
//        module.addDeserializer(UsernamePasswordAuthenticationToken.class, new CustomUsernamePasswordAuthenticationTokenDeserializer());
//        objectMapper.registerModule(module);
//        return new GenericJackson2JsonRedisSerializer(objectMapper);
//    }

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        System.out.println("redis 설정");
        System.out.println(redisHost);
        System.out.println(redisPort);
        System.out.println(redisPassword);
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(redisHost);
        redisStandaloneConfiguration.setPort(redisPort);
        redisStandaloneConfiguration.setPassword(redisPassword);
        return new LettuceConnectionFactory(redisStandaloneConfiguration);
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(redisConnectionFactory);

        // 키에 대해 StringRedisSerializer 사용
        stringRedisTemplate.setKeySerializer(new StringRedisSerializer());

        // 값에 대해 GenericJackson2JsonRedisSerializer 사용
        stringRedisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        // 기본 직렬화 방식 설정 (옵션 - 주로 값 직렬화와 같게 설정합니다)
        stringRedisTemplate.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());

        stringRedisTemplate.afterPropertiesSet();
        return stringRedisTemplate;
    }
}