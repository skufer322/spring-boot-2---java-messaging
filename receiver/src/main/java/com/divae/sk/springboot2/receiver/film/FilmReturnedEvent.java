package com.divae.sk.springboot2.receiver.film;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public
class FilmReturnedEvent {

    String title;
}

