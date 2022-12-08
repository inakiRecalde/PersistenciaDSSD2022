package com.example.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="TIPOS")
public class Tipo {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column(name="NOMBRE")
    private String nombre;
    
    
    public Tipo() {
        super();
    }

    
    public Tipo(String nombre) {
        this.nombre = nombre;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
