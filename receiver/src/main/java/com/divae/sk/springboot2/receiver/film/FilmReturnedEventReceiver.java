package com.divae.sk.springboot2.receiver.film;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FilmReturnedEventReceiver {

    @StreamListener(Sink.INPUT)
    public void filmReturned(FilmReturnedEvent event) {
        log.info("Film '{}' returned, billing customer...", event);
    }
}
