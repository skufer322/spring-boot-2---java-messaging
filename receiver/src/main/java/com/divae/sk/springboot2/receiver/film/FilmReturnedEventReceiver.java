package com.divae.sk.springboot2.receiver.film;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FilmReturnedEventReceiver {

    public void filmReturned(FilmReturnedEvent event) {

        log.info("Film '{}' returned, billing customer...", event);
    }
}
