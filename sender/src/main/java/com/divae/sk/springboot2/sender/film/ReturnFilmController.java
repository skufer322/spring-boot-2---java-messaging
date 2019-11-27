package com.divae.sk.springboot2.sender.film;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReturnFilmController {

    private final FilmService filmService;
    private final RedisTemplate redisTemplate;

    @GetMapping("/return-film")
    public String returnFilm() {
        FilmReturnedEvent film = filmService.getReturnedFilm();
        redisTemplate.convertAndSend("returned-films-events", film);
        return "Film " + film + " was returned!";
    }
}

