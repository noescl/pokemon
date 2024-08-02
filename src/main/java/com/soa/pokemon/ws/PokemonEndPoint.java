package com.soa.pokemon.ws;

import com.soa.pokemon.client.ApiClientPokemon;
import com.soa.pokemon.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pokemon.com.api.GetPokemonRequest;
import pokemon.com.api.GetPokemonResponse;
import pokemon.com.api.GetAbilitiesRequest;
import pokemon.com.api.GetBaseExperienceRequest;
import pokemon.com.api.GetHeldItemsRequest;
import pokemon.com.api.GetIdRequest;
import pokemon.com.api.GetNameRequest;
import pokemon.com.api.GetLocationAreaEncountersRequest;
import pokemon.com.api.Pokemon;

import java.math.BigInteger;
@Endpoint
public class PokemonEndPoint {
    private static final Logger LOG  = LoggerFactory.getLogger( PokemonEndPoint.class);
    private static final String NAMESPACE_URI = "http://com.pokemon/api";
    private PokemonResponse getPokemon(String name){
        ApiClientPokemon apiClientPokemon = new ApiClientPokemon();
        PokemonResponse pokemonResponse = new PokemonResponse();
        try{
            pokemonResponse = apiClientPokemon.sendGet(name);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            apiClientPokemon.close();
        }
        return pokemonResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetPokemonRequest")
    @ResponsePayload
    public GetPokemonResponse getPokemon(@RequestPayload GetPokemonRequest request) {
        LOG.info("GetPokemonResponse :: " + "/" + request.getName());
        GetPokemonResponse getPokemonResponse = new GetPokemonResponse();
        PokemonResponse pokemonResponse = getPokemon(request.getName());
        if(pokemonResponse == null)
            return getPokemonResponse;
        else {
            Pokemon pokemon = new Pokemon();
            pokemon.setName(pokemonResponse.getName());
            pokemon.setBaseExperience(BigInteger.valueOf(pokemonResponse.getBase_experience()));
            pokemon.setId(BigInteger.valueOf(pokemonResponse.getId()));
            pokemon.setLocationAreaEncounters(pokemonResponse.getLocation_area_encounters());

            for (Held held : pokemonResponse.getHeld_items()) {
                pokemon.com.api.Held h = new pokemon.com.api.Held();
                pokemon.com.api.HeldItem heldItem = new pokemon.com.api.HeldItem();
                heldItem.setName(held.getItem().getName());
                heldItem.setUrl(held.getItem().getUrl());
                h.setItem(heldItem);
                for (VersionDetail version : held.getVersionDetails()) {
                    pokemon.com.api.VersionDetail versionDetail = new pokemon.com.api.VersionDetail();
                    pokemon.com.api.Version v = new pokemon.com.api.Version();
                    v.setName(version.getVersion().getName());
                    v.setUrl(version.getVersion().getUrl());
                    versionDetail.setVersion(v);
                    versionDetail.setRarity(version.getRarity());
                    h.getVersionDetails().add(versionDetail);
                }
                pokemon.getHeldItems().add(h);
            }

            for (Ability ability : pokemonResponse.getAbilities()) {
                pokemon.com.api.Ability a = new pokemon.com.api.Ability();
                a.setSlot(ability.getSlot());
                a.setIsHidden(ability.isHidden());
                pokemon.com.api.AbilityObject abilityObject = new pokemon.com.api.AbilityObject();
                abilityObject.setName(ability.getAbilityObject().getName());
                abilityObject.setUrl(ability.getAbilityObject().getUrl());
                a.setAbility(abilityObject);
                pokemon.getAbilities().add(a);
            }
            getPokemonResponse.setPokemon(pokemon);
            LOG.info("RESPONSE :: " + pokemonResponse);

            return getPokemonResponse;
        }
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAbilitiesRequest")
    @ResponsePayload
    public GetPokemonResponse getAbilities(@RequestPayload GetAbilitiesRequest request) {
        LOG.info("GetAbilitiesRequest :: " + "/" + request.getName());
        GetPokemonResponse getPokemonResponse = new GetPokemonResponse();
        PokemonResponse pokemonResponse = getPokemon(request.getName());

        if(pokemonResponse == null)
            return getPokemonResponse;
        else {
            Pokemon pokemon = new Pokemon();
            for (Ability ability : pokemonResponse.getAbilities()) {
                pokemon.com.api.Ability a = new pokemon.com.api.Ability();
                a.setSlot(ability.getSlot());
                a.setIsHidden(ability.isHidden());
                pokemon.com.api.AbilityObject abilityObject = new pokemon.com.api.AbilityObject();
                abilityObject.setName(ability.getAbilityObject().getName());
                abilityObject.setUrl(ability.getAbilityObject().getUrl());
                a.setAbility(abilityObject);
                pokemon.getAbilities().add(a);
            }
            GetPokemonResponse response = new GetPokemonResponse();
            response.setPokemon(pokemon);
            LOG.info("RESPONSE WS :: " + pokemonResponse);
            return response;
        }
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetBaseExperienceRequest")
    @ResponsePayload
    public GetPokemonResponse getBaseExperience(@RequestPayload GetBaseExperienceRequest request) {
        LOG.info("GetBaseExperienceRequest :: " + "/" + request.getName());
        GetPokemonResponse getPokemonResponse = new GetPokemonResponse();
        PokemonResponse pokemonResponse = getPokemon(request.getName());

        if(pokemonResponse == null)
            return getPokemonResponse;
        else {
            Pokemon pokemon = new Pokemon();
            pokemon.setBaseExperience(BigInteger.valueOf(pokemonResponse.getBase_experience()));
            GetPokemonResponse response = new GetPokemonResponse();
            response.setPokemon(pokemon);
            LOG.info("RESPONSE WS :: " + pokemonResponse);
            return response;
        }
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetHeldItemsRequest")
    @ResponsePayload
    public GetPokemonResponse getHeldItems(@RequestPayload GetHeldItemsRequest request) {
        LOG.info("GetHeldItemsRequest :: " + "/" + request.getName());
        GetPokemonResponse getPokemonResponse = new GetPokemonResponse();
        PokemonResponse pokemonResponse = getPokemon(request.getName());

        if(pokemonResponse == null)
            return getPokemonResponse;
        else {
            Pokemon pokemon = new Pokemon();

            for (Held held : pokemonResponse.getHeld_items()) {
                pokemon.com.api.Held h = new pokemon.com.api.Held();
                pokemon.com.api.HeldItem heldItem = new pokemon.com.api.HeldItem();
                heldItem.setName(held.getItem().getName());
                heldItem.setUrl(held.getItem().getUrl());
                h.setItem(heldItem);
                for (VersionDetail version : held.getVersionDetails()) {
                    pokemon.com.api.VersionDetail versionDetail = new pokemon.com.api.VersionDetail();
                    pokemon.com.api.Version v = new pokemon.com.api.Version();
                    v.setName(version.getVersion().getName());
                    v.setUrl(version.getVersion().getUrl());
                    versionDetail.setVersion(v);
                    versionDetail.setRarity(version.getRarity());
                    h.getVersionDetails().add(versionDetail);
                }
                pokemon.getHeldItems().add(h);
            }
            GetPokemonResponse response = new GetPokemonResponse();
            response.setPokemon(pokemon);
            LOG.info("RESPONSE WS :: " + pokemonResponse);
            return response;
        }
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetIdRequest")
    @ResponsePayload
    public GetPokemonResponse getId(@RequestPayload GetIdRequest request) {
        LOG.info("GetIdRequest :: " + "/" + request.getName());
        GetPokemonResponse getPokemonResponse = new GetPokemonResponse();
        PokemonResponse pokemonResponse = getPokemon(request.getName());

        if(pokemonResponse == null)
            return getPokemonResponse;
        else {
            Pokemon pokemon = new Pokemon();
            pokemon.setId(BigInteger.valueOf(pokemonResponse.getId()));
            GetPokemonResponse response = new GetPokemonResponse();
            response.setPokemon(pokemon);
            LOG.info("RESPONSE ::: " + pokemonResponse);

            return response;
        }
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetNameRequest")
    @ResponsePayload
    public GetPokemonResponse getName(@RequestPayload GetNameRequest request) {
        LOG.info(" GetNameRequest :: " + "/" + request.getName());
        GetPokemonResponse getPokemonResponse = new GetPokemonResponse();
        PokemonResponse pokemonResponse = getPokemon(request.getName());
        if(pokemonResponse == null)
            return getPokemonResponse;
        else {
            Pokemon pokemon = new Pokemon();
            pokemon.setName(pokemonResponse.getName());
            GetPokemonResponse response = new GetPokemonResponse();
            response.setPokemon(pokemon);
            LOG.info("RESPONSE :: " + pokemonResponse);

            return response;
        }
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetLocationAreaEncountersRequest")
    @ResponsePayload
    public GetPokemonResponse getLocationAreaEncounters(@RequestPayload GetLocationAreaEncountersRequest request) {
        LOG.info(" GetLocationAreaEncountersRequest :: " + "/" + request.getName());
        GetPokemonResponse getPokemonResponse = new GetPokemonResponse();
        PokemonResponse pokemonResponse = getPokemon(request.getName());

        if(pokemonResponse == null)
            return getPokemonResponse;
        else {
            Pokemon pokemon = new Pokemon();
            pokemon.setLocationAreaEncounters(pokemonResponse.getLocation_area_encounters());
            GetPokemonResponse response = new GetPokemonResponse();
            response.setPokemon(pokemon);
            LOG.info("RESPONSE :: " + pokemonResponse);

            return response;
        }
    }
 }
