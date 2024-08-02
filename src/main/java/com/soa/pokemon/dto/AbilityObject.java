package com.soa.pokemon.dto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AbilityObject {
    private String name;
    private String url;

    @Override
    public String toString() {
        return "AbilityObject{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
