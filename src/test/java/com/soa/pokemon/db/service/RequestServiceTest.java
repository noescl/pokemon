package com.soa.pokemon.db.service;

import com.soa.pokemon.db.entity.Request;
import com.soa.pokemon.db.repository.RequestRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
class RequestServiceTest {
    //@Autowired
    @Autowired
    RequestRepository requestRepository;
    @Test
    void list() {
        List<Request> cuentas = requestRepository.findAll();
        System.out.println(cuentas);
        Assertions.assertThat(cuentas.size()).isEqualTo(0);
    }
}