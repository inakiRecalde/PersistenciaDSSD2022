package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.*;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

}