package com.soa.pokemon.dto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Ability {
    private AbilityObject abilityObject;
    private boolean isHidden;
    private int slot;

    @Override
    public String toString() {
        return "Ability{" +
                "abilityObject=" + abilityObject +
                ", isHidden=" + isHidden +
                ", slot=" + slot +
                '}';
    }
}
