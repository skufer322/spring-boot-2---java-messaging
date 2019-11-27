package com.divae.sk.springboot2.receiver.film.configuration;

import com.divae.sk.springboot2.receiver.film.FilmReturnedEvent;
import com.divae.sk.springboot2.receiver.film.FilmReturnedEventReceiver;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.jackson.JsonComponentModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
public class Config {

    @Bean
    FilmReturnedEventReceiver filmReturnedEventReceiver() {
        return new FilmReturnedEventReceiver();
    }

    @Bean
    ObjectMapper objectMapper(final JsonComponentModule jsonComponentModule) {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(jsonComponentModule);
        return objectMapper;
    }

    @Bean
    MessageListenerAdapter eventReceiverAdapter(FilmReturnedEventReceiver eventReceiver, ObjectMapper objectMapper) {
        final MessageListenerAdapter adapter = new MessageListenerAdapter(eventReceiver, "filmReturned");
        final Jackson2JsonRedisSerializer<FilmReturnedEvent> serializer = new Jackson2JsonRedisSerializer<>(FilmReturnedEvent.class);
        serializer.setObjectMapper(objectMapper);
        adapter.setSerializer(serializer);
        return adapter;
    }

    @Bean
    RedisMessageListenerContainer messageListenerContainer(MessageListenerAdapter eventReceiverAdapter, RedisConnectionFactory connectionFactory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(eventReceiverAdapter, new PatternTopic("returned-films-events"));
        return container;
    }
}

