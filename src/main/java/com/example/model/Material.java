package com.example.model;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;


@Entity
@Table(name="MATERIALES")
public class Material {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column(name="NOMBRE")
    private String nombre;
    
    @Column(name="CANTIDAD")
    private int cantidad;
    
    @Column(name="FECHAINICIO")
    private String fechaInicio;
    
    @Column(name="FECHAFIN")
    private String fechaFin;
    
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="plan_id")
	@JsonIgnoreProperties(value="planes")
    private Plan plan;
	
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="modelo_id")
    @JsonIgnoreProperties(value="materiales")
    private Modelo modelo;
    
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="proovedor_id")
	@JsonIgnoreProperties(value="materiales")
    private Proveedor proveedor;
    
	
    public Material() {
        super();
    }

    
    public Material(String nombre,int cantidad, Proveedor proveedor, String fechaInicio, String fechaFin) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.proveedor = proveedor;
        this.fechaInicio =fechaInicio;
        this.fechaFin = fechaFin;
    }
    





	public Modelo getModelo() {
		return modelo;
	}


	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}


	public Plan getPlan() {
		return plan;
	}


	public void setPlan(Plan plan) {
		this.plan = plan;
	}


	public String getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public String getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Proveedor getProveedor() {
        return proveedor;
    }


    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
