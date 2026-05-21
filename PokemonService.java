package com.pokedex.service;

import com.pokedex.dto.PokemonDTO;

import java.util.List;

public interface PokemonService {

    List<PokemonDTO> getAllPokemon();

    PokemonDTO getPokemonById(Long id);

    PokemonDTO getPokemonByName(String name);

    List<PokemonDTO> searchPokemonByName(String name);

    List<PokemonDTO> getPokemonByType(String type);

    PokemonDTO addPokemon(PokemonDTO pokemonDTO);

    PokemonDTO updatePokemon(Long id, PokemonDTO pokemonDTO);

    void deletePokemon(Long id);
}
