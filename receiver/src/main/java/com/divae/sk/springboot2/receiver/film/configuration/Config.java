package com.divae.sk.springboot2.receiver.film.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.jackson.JsonComponentModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;

@Configuration
public class Config {

    @Bean
    ObjectMapper objectMapper(final JsonComponentModule jsonComponentModule) {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(jsonComponentModule);
        return objectMapper;
    }

    @Bean
    MessageConverter messageConverter(final ObjectMapper objectMapper) {
        final MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setObjectMapper(objectMapper);

        return converter;
    }
}

