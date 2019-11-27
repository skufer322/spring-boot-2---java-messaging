package com.divae.sk.springboot2.receiver.film.configuration;

import com.divae.sk.springboot2.receiver.film.FilmReturnedEvent;
import com.divae.sk.springboot2.receiver.film.FilmReturnedEventReceiver;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.jackson.JsonComponentModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListenerConfigurer;
import org.springframework.jms.config.SimpleJmsListenerEndpoint;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class Config {

    @Bean
    ObjectMapper objectMapper(final JsonComponentModule jsonComponentModule) {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(jsonComponentModule);
        return objectMapper;
    }

    @Bean
    FilmReturnedEventReceiver filmReturnedEventReceiver() {
        return new FilmReturnedEventReceiver();
    }

    @Bean
    MessageConverter filmReturnedEventConverter(final ObjectMapper objectMapper) {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setObjectMapper(objectMapper);
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("eventType");
        final Map<String, Class<?>> t = new HashMap<>();
        t.put("FilmReturnedEvent", FilmReturnedEvent.class);
        converter.setTypeIdMappings(t);
        return converter;
    }

    @Bean
    MessageListenerAdapter filmReturnedEventListener(final MessageConverter filmReturnedEventConverter,
                                                     final FilmReturnedEventReceiver filmReturnedEventReceiver) {
        final MessageListenerAdapter adapter = new MessageListenerAdapter(filmReturnedEventReceiver);
        adapter.setDefaultListenerMethod("filmReturned");
        adapter.setMessageConverter(filmReturnedEventConverter);
        return adapter;
    }

    @Bean
    JmsListenerConfigurer jmsListenerConfigurer(MessageListenerAdapter filmReturnedEventListener) {
        return registrar -> {
            final SimpleJmsListenerEndpoint rv = new SimpleJmsListenerEndpoint();
            rv.setId("returned-film-events-receiver");
            rv.setMessageListener(filmReturnedEventListener);
            rv.setDestination("returned-film-events");

            registrar.registerEndpoint(rv);
        };
    }
}

