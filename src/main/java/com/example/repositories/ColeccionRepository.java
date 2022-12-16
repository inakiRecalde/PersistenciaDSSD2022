package com.example.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.*;

@Repository
public interface ColeccionRepository  extends JpaRepository<Coleccion, Long> {
	
	public List<Coleccion> findAllByLanzado(boolean lanzado);
	
	public List<Coleccion> findAllByNegociado(boolean negociado);
}
