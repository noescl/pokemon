package com.soa.pokemon.db.repository;

import com.soa.pokemon.db.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository  extends JpaRepository<Request, Long> {
}
