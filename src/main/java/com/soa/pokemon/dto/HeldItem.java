package com.soa.pokemon.dto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class HeldItem {
    private String name;
    private String url;

    @Override
    public String toString() {
        return "HeldItem{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
