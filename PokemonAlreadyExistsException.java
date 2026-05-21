package com.pokedex.exception;

public class PokemonAlreadyExistsException extends RuntimeException {

    public PokemonAlreadyExistsException(String name) {
        super("A Pokémon with the name '" + name + "' already exists.");
    }

    public PokemonAlreadyExistsException(Integer pokedexNumber) {
        super("A Pokémon with Pokédex number #" + pokedexNumber + " already exists.");
    }
}
