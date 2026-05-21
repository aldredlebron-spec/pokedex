package com.pokedex.exception;

public class PokemonNotFoundException extends RuntimeException {

    public PokemonNotFoundException(Long id) {
        super("Pokémon not found with ID: " + id);
    }

    public PokemonNotFoundException(String name) {
        super("Pokémon not found with name: " + name);
    }

    public PokemonNotFoundException(String field, Object value) {
        super("Pokémon not found with " + field + ": " + value);
    }
}
