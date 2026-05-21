package com.pokedex.service;

import com.pokedex.dto.PokemonDTO;
import com.pokedex.exception.PokemonAlreadyExistsException;
import com.pokedex.exception.PokemonNotFoundException;
import com.pokedex.model.Pokemon;
import com.pokedex.repository.PokemonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonServiceImpl implements PokemonService {

    private final PokemonRepository pokemonRepository;

    public PokemonServiceImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public List<PokemonDTO> getAllPokemon() {
        return pokemonRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PokemonDTO getPokemonById(Long id) {
        Pokemon pokemon = pokemonRepository.findById(id)
                .orElseThrow(() -> new PokemonNotFoundException(id));
        return toDTO(pokemon);
    }

    @Override
    public PokemonDTO getPokemonByName(String name) {
        Pokemon pokemon = pokemonRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new PokemonNotFoundException(name));
        return toDTO(pokemon);
    }

    @Override
    public List<PokemonDTO> searchPokemonByName(String name) {
        return pokemonRepository.searchByName(name)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PokemonDTO> getPokemonByType(String type) {
        return pokemonRepository.findByType(type)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PokemonDTO addPokemon(PokemonDTO pokemonDTO) {
        if (pokemonRepository.existsByNameIgnoreCase(pokemonDTO.getName())) {
            throw new PokemonAlreadyExistsException(pokemonDTO.getName());
        }
        if (pokemonRepository.existsByPokedexNumber(pokemonDTO.getPokedexNumber())) {
            throw new PokemonAlreadyExistsException(pokemonDTO.getPokedexNumber());
        }
        Pokemon pokemon = toEntity(pokemonDTO);
        Pokemon saved = pokemonRepository.save(pokemon);
        return toDTO(saved);
    }

    @Override
    public PokemonDTO updatePokemon(Long id, PokemonDTO pokemonDTO) {
        Pokemon existing = pokemonRepository.findById(id)
                .orElseThrow(() -> new PokemonNotFoundException(id));

        pokemonRepository.findByNameIgnoreCase(pokemonDTO.getName())
                .ifPresent(p -> {
                    if (!p.getId().equals(id)) {
                        throw new PokemonAlreadyExistsException(pokemonDTO.getName());
                    }
                });

        pokemonRepository.findByPokedexNumber(pokemonDTO.getPokedexNumber())
                .ifPresent(p -> {
                    if (!p.getId().equals(id)) {
                        throw new PokemonAlreadyExistsException(pokemonDTO.getPokedexNumber());
                    }
                });

        existing.setPokedexNumber(pokemonDTO.getPokedexNumber());
        existing.setName(pokemonDTO.getName());
        existing.setPrimaryType(pokemonDTO.getPrimaryType());
        existing.setSecondaryType(pokemonDTO.getSecondaryType());
        existing.setHeight(pokemonDTO.getHeight());
        existing.setWeight(pokemonDTO.getWeight());
        existing.setDescription(pokemonDTO.getDescription());

        return toDTO(pokemonRepository.save(existing));
    }

    @Override
    public void deletePokemon(Long id) {
        if (!pokemonRepository.existsById(id)) {
            throw new PokemonNotFoundException(id);
        }
        pokemonRepository.deleteById(id);
    }

    private PokemonDTO toDTO(Pokemon pokemon) {
        return PokemonDTO.builder()
                .id(pokemon.getId())
                .pokedexNumber(pokemon.getPokedexNumber())
                .name(pokemon.getName())
                .primaryType(pokemon.getPrimaryType())
                .secondaryType(pokemon.getSecondaryType())
                .height(pokemon.getHeight())
                .weight(pokemon.getWeight())
                .description(pokemon.getDescription())
                .build();
    }

    private Pokemon toEntity(PokemonDTO dto) {
        return Pokemon.builder()
                .pokedexNumber(dto.getPokedexNumber())
                .name(dto.getName())
                .primaryType(dto.getPrimaryType())
                .secondaryType(dto.getSecondaryType())
                .height(dto.getHeight())
                .weight(dto.getWeight())
                .description(dto.getDescription())
                .build();
    }
}
