package com.example.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="PROVEEDORES")
public class Proveedor {


    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column(name="NOMBRE")
    private String nombre;
    
    @Column(name="TIPOS")
    private String tipo;
    
    @Column(name="DIRECCION")
    String direccion;

    @OneToMany(mappedBy = "proveedor",cascade = CascadeType.REMOVE)
    private List<Material> materiales;
    
    public Proveedor() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Proveedor(Long id, String nombre, String tipo, String direccion) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.direccion = direccion;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
