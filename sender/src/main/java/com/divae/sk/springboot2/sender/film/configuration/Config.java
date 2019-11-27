package com.divae.sk.springboot2.sender.film.configuration;

import com.divae.sk.springboot2.sender.film.FilmReturnedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class Config {

    @Bean
    MappingJackson2MessageConverter filmReturnedEventConverter() {
        final MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("eventType");
        final Map<String, Class<?>> t = new HashMap<>();
        t.put("FilmReturnedEvent", FilmReturnedEvent.class);
        converter.setTypeIdMappings(t);
        return converter;
    }

}
