package com.divae.sk.springboot2.sender.film;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.io.Serializable;

@Value
@RequiredArgsConstructor
@Builder(toBuilder = true)
public
class FilmReturnedEvent implements Serializable {

    String inventoryId;
    String title;
}

