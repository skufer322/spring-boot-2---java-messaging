package com.divae.sk.springboot2.sender.film;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FilmService {

    FilmReturnedEvent getReturnedFilm(){
        return FilmReturnedEvent.builder()
                .inventoryId(UUID.randomUUID().toString())
                .title("Das große Fressen")
                .build();
    }
}

