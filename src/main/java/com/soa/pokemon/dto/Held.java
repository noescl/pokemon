package com.soa.pokemon.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Held {
    private HeldItem item;
    private List<VersionDetail> versionDetails;

    @Override
    public String toString() {
        return "Held{" +
                "item=" + item +
                ", versionDetails=" + versionDetails +
                '}';
    }
}
