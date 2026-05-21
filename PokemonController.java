package com.pokedex.controller;

import com.pokedex.dto.PokemonDTO;
import com.pokedex.service.PokemonService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public ResponseEntity<List<PokemonDTO>> getAllPokemon() {
        return ResponseEntity.ok(pokemonService.getAllPokemon());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PokemonDTO> getPokemonById(@PathVariable Long id) {
        return ResponseEntity.ok(pokemonService.getPokemonById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PokemonDTO> getPokemonByName(@PathVariable String name) {
        return ResponseEntity.ok(pokemonService.getPokemonByName(name));
    }

    @GetMapping("/search")
    public ResponseEntity<List<PokemonDTO>> searchPokemon(@RequestParam String name) {
        return ResponseEntity.ok(pokemonService.searchPokemonByName(name));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<PokemonDTO>> getPokemonByType(@PathVariable String type) {
        return ResponseEntity.ok(pokemonService.getPokemonByType(type));
    }

    @PostMapping
    public ResponseEntity<PokemonDTO> addPokemon(@Valid @RequestBody PokemonDTO pokemonDTO) {
        PokemonDTO created = pokemonService.addPokemon(pokemonDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PokemonDTO> updatePokemon(@PathVariable Long id, @Valid @RequestBody PokemonDTO pokemonDTO) {
        return ResponseEntity.ok(pokemonService.updatePokemon(id, pokemonDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePokemon(@PathVariable Long id) {
        pokemonService.deletePokemon(id);
        return ResponseEntity.noContent().build();
    }
}
