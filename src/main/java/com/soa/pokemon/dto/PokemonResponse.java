package com.soa.pokemon.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class PokemonResponse {
    private ArrayList<Ability> abilities;
    private Integer base_experience;
    private ArrayList <Held> held_items;
    private int id;
    private String name;
    private String location_area_encounters;

    @Override
    public String toString() {
        return "PokemonResponse{" +
                "abilities=" + abilities +
                ", base_experience=" + base_experience +
                ", held_items=" + held_items +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", location_area_encounters='" + location_area_encounters + '\'' +
                '}';
    }
}
