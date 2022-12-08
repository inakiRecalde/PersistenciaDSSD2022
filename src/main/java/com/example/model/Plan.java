package com.example.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name="PLANES")
public class Plan {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy="plan", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties(value="plan")
    private List<Material> materiales;
    
    @Column(name="RUTAS")
    private String rutas;
    
    @Column(name="LANZADO")
    private Boolean lanzado;
    
    @Column(name="NEGOCIADO")
    private Boolean renegociado;
    
    @OneToOne(optional = true)
    private Coleccion coleccion;
    
    public Plan() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Plan(List<Material> materiales, String rutas, Boolean lanzado,
            Boolean renegociado, Coleccion coleccion) {
        super();
        this.materiales = materiales;
        this.rutas = rutas;
        this.lanzado = lanzado;
        this.renegociado = renegociado;
        this.coleccion = coleccion; 
    }
    
    

    public List<Material> getMateriales() {
        return materiales;
    }

    public void setMateriales(List<Material> materiales) {
        this.materiales = materiales;
    }

    public String getRutas() {
        return rutas;
    }

    public void setRutas(String rutas) {
        this.rutas = rutas;
    }


    public Boolean getLanzado() {
        return lanzado;
    }

    public void setLanzado(Boolean lanzado) {
        this.lanzado = lanzado;
    }

    public Boolean getRenegociado() {
        return renegociado;
    }

    public void setRenegociado(Boolean renegociado) {
        this.renegociado = renegociado;
    }
    
}
