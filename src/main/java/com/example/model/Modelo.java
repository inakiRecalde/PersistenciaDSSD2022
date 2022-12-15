package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name="MODELOS")
public class Modelo {
    
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column(name="NOMBRE")
    String nombre; 
    
      
    @ManyToOne()
    @JoinColumn(name="coleccion_id")
    @JsonIgnoreProperties(value="modelos")
    private Coleccion coleccion;
    

    public Long getId() {
        return id;
    }
    public Modelo() {
        super();
    }

    public Modelo(Long id, String nombre, Coleccion coleccion) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.coleccion = coleccion;
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



 
	public Coleccion getColeccion() {
		return coleccion;
	}
	public void setColeccion(Coleccion coleccion) {
		this.coleccion = coleccion;
	}
    
    
}
