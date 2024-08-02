package com.soa.pokemon.dto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class VersionDetail {
    private  int rarity;
    private  Version version;

    @Override
    public String toString() {
        return "VersionDetail{" +
                "rarity=" + rarity +
                ", version=" + version +
                '}';
    }
}
