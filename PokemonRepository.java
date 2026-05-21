package com.pokedex.repository;

import com.pokedex.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    // Search by name (case-insensitive)
    Optional<Pokemon> findByNameIgnoreCase(String name);

    // Check existence by name for validation
    boolean existsByNameIgnoreCase(String name);

    // Check existence by pokedex number
    boolean existsByPokedexNumber(Integer pokedexNumber);

    // Filter by primary or secondary type (case-insensitive)
    @Query("SELECT p FROM Pokemon p WHERE " +
           "LOWER(p.primaryType) = LOWER(:type) OR " +
           "LOWER(p.secondaryType) = LOWER(:type)")
    List<Pokemon> findByType(@Param("type") String type);

    // Search by partial name
    @Query("SELECT p FROM Pokemon p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Pokemon> searchByName(@Param("name") String name);

    // Find by Pokédex number
    Optional<Pokemon> findByPokedexNumber(Integer pokedexNumber);
}
