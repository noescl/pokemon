package com.soa.pokemon.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Version {
    private String name;
    private String url;

    @Override
    public String toString() {
        return "Version{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
