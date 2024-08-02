package com.soa.pokemon.client;

import com.google.gson.Gson;
import com.soa.pokemon.dto.PokemonResponse;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ApiClientPokemon {
    private static final Logger LOG  = LoggerFactory.getLogger( ApiClientPokemon.class);
    public static String URI = "https://pokeapi.co/api/v2/pokemon/";
    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    public PokemonResponse sendGet(String pokemon) throws Exception {
        HttpGet request = new HttpGet(URI + pokemon);
        PokemonResponse pokemonResponse = new PokemonResponse();
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            Gson gson = new Gson();
            LOG.info("REQUEST : " + request);
            LOG.info("RESPONSE : " + response);
            if (response.getStatusLine().getStatusCode() == 200) {
                pokemonResponse = gson.fromJson(result, PokemonResponse.class);
                return pokemonResponse;
            }
        }
        return null;
    }
    public void close(){
        try{
            httpClient.close();
        }catch (IOException e){
            LOG.error("Error trying to clos Httpclient");
            e.printStackTrace();
         }
    }
}
