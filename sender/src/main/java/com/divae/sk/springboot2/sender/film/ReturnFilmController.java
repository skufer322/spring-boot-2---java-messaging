package com.divae.sk.springboot2.sender.film;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReturnFilmController {

    private final FilmService filmService;
    // TODO template

    @GetMapping("/return-film")
    public String returnFilm() {
        FilmReturnedEvent film = filmService.getReturnedFilm();
        // TODO: template verwenden
        return "Film " + film + " was returned!";
    }
}

