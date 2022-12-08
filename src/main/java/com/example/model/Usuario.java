package com.example.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name="USUARIOS")
public class Usuario {
    
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column(name="NOMBRE")
    private String nombre;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnoreProperties(value="usuario")
    private List<Coleccion> coleccion;
    
    public Usuario(String nombre, List<Coleccion> coleccion) {
        this.nombre = nombre;
        this.coleccion= coleccion;
    }

    public Usuario() {
        super();
        // TODO Auto-generated constructor stub
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

	public List<Coleccion> getColeccion() {
		return coleccion;
	}

	public void setColeccion(List<Coleccion> coleccion) {
		this.coleccion = coleccion;
	}


    
}
