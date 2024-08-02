package com.soa.pokemon;

import com.soa.pokemon.db.entity.Request;
import com.soa.pokemon.db.repository.RequestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
class PokemonApplicationTests {

	@MockBean
	RequestRepository requestRepository;
	@Test
	void contextLoads() {
		when(requestRepository.findById(1L)).thenReturn(crearRequest());
		verify(requestRepository, never()).findAll();
	}
	public static Optional<Request> crearRequest() {
		java.sql.Timestamp date = new java.sql.Timestamp(System.currentTimeMillis());
		String strDate = date.toString();
		return Optional.of(new Request(new Long(1),"127.0.0.0", date,"GetIdRequest"));
	}
}
//verify(requestRepository).save(any(Request.class));
//verify(requestRepository.save(crearRequest()));