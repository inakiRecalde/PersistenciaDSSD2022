package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.*;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {
	
	List<Modelo> findAllByColeccion(Coleccion coleccion);
	
}
