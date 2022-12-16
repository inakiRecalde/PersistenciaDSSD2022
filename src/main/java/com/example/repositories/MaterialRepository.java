package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.*;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {

	List<Material> findAllByColeccion(Coleccion coleccion);
}
