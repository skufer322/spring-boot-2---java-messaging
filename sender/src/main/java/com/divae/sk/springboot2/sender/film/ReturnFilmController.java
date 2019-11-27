package com.divae.sk.springboot2.sender.film;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReturnFilmController {

    private final FilmService filmService;
    private final AmqpTemplate amqpTemplate;

    @GetMapping("/return-film")
    public String returnFilm(){
        FilmReturnedEvent film = filmService.getReturnedFilm();
        amqpTemplate.convertAndSend("returned-film-events", film);
        return "Film " + film + " was returned!";
    }
}

