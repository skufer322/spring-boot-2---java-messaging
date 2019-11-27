package com.divae.sk.springboot2.sender.film.configuration;

import com.divae.sk.springboot2.sender.film.FilmReturnedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
public class Config {

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory connectionFactory) {
        final RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(FilmReturnedEvent.class));
        return redisTemplate;
    }
}
