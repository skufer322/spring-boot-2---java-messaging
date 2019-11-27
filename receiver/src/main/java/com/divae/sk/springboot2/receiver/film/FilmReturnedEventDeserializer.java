package com.divae.sk.springboot2.receiver.film;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class FilmReturnedEventDeserializer extends JsonDeserializer<FilmReturnedEvent> {

    @Override
    public FilmReturnedEvent deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        final JsonNode node = p.getCodec().readTree(p);
        return new FilmReturnedEvent(node.get("title").asText());
    }
}

