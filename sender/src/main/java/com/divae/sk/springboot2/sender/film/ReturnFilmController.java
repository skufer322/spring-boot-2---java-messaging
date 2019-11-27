package com.divae.sk.springboot2.sender.film;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReturnFilmController {

    private final FilmService filmService;
    private final Source source;

    @GetMapping("/return-film")
    public String returnFilm() {
        FilmReturnedEvent film = filmService.getReturnedFilm();
        Message<FilmReturnedEvent> message = MessageBuilder.withPayload(film).build();
        source.output().send(message);
        return "Film " + film + " was returned!";
    }
}

