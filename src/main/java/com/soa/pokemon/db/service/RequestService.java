package com.soa.pokemon.db.service;

import com.soa.pokemon.db.entity.Request;
import com.soa.pokemon.db.repository.RequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {
    private static final Logger LOG  = LoggerFactory.getLogger( RequestService.class);
    private final RequestRepository requestRepository;

    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }
    public List<Request> list(){
        return requestRepository.findAll();
    }
    public void insertRequest(Request request){
        LOG.info("ENTRO AL SAVE Request"+request.toString());
        this.requestRepository.save(request);
        LOG.info("Save Request"+request.toString());
    }
}
