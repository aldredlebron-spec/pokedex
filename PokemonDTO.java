package com.pokedex.dto;

import jakarta.validation.constraints.*;

public class PokemonDTO {

    private Long id;

    @NotNull(message = "Pokédex number is required")
    @Min(value = 1, message = "Pokédex number must be at least 1")
    @Max(value = 151, message = "Generation 1 only supports up to 151 Pokémon")
    private Integer pokedexNumber;

    @NotBlank(message = "Name is required")
    @Size(max = 50, message = "Name must not exceed 50 characters")
    private String name;

    @NotBlank(message = "Primary type is required")
    private String primaryType;

    private String secondaryType;

    @NotNull(message = "Height is required")
    @DecimalMin(value = "0.1", message = "Height must be greater than 0")
    private Double height;

    @NotNull(message = "Weight is required")
    @DecimalMin(value = "0.1", message = "Weight must be greater than 0")
    private Double weight;

    @Size(max = 500)
    private String description;

    public PokemonDTO() {}

    public PokemonDTO(Long id, Integer pokedexNumber, String name, String primaryType,
                      String secondaryType, Double height, Double weight, String description) {
        this.id = id;
        this.pokedexNumber = pokedexNumber;
        this.name = name;
        this.primaryType = primaryType;
        this.secondaryType = secondaryType;
        this.height = height;
        this.weight = weight;
        this.description = description;
    }

    public Long getId() { return id; }
    public Integer getPokedexNumber() { return pokedexNumber; }
    public String getName() { return name; }
    public String getPrimaryType() { return primaryType; }
    public String getSecondaryType() { return secondaryType; }
    public Double getHeight() { return height; }
    public Double getWeight() { return weight; }
    public String getDescription() { return description; }

    public void setId(Long id) { this.id = id; }
    public void setPokedexNumber(Integer pokedexNumber) { this.pokedexNumber = pokedexNumber; }
    public void setName(String name) { this.name = name; }
    public void setPrimaryType(String primaryType) { this.primaryType = primaryType; }
    public void setSecondaryType(String secondaryType) { this.secondaryType = secondaryType; }
    public void setHeight(Double height) { this.height = height; }
    public void setWeight(Double weight) { this.weight = weight; }
    public void setDescription(String description) { this.description = description; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Long id;
        private Integer pokedexNumber;
        private String name;
        private String primaryType;
        private String secondaryType;
        private Double height;
        private Double weight;
        private String description;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder pokedexNumber(Integer pokedexNumber) { this.pokedexNumber = pokedexNumber; return this; }
        public Builder name(String name) { this.name = name; return this; }
        public Builder primaryType(String primaryType) { this.primaryType = primaryType; return this; }
        public Builder secondaryType(String secondaryType) { this.secondaryType = secondaryType; return this; }
        public Builder height(Double height) { this.height = height; return this; }
        public Builder weight(Double weight) { this.weight = weight; return this; }
        public Builder description(String description) { this.description = description; return this; }

        public PokemonDTO build() {
            return new PokemonDTO(id, pokedexNumber, name, primaryType, secondaryType, height, weight, description);
        }
    }
}
