package com.divae.sk.springboot2.sender.film.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;

public class Config {

    @Bean
    MessageConverter filmReturnedEventConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    Queue returnFilmEventsQueue() {
        return new Queue("returned-film-events", true);
    }
}
