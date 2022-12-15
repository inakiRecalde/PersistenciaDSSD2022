package com.example.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="COLECCIONES")
public class Coleccion {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column(name="CARACTERISTICAS")
	private String caracteristicas;
    
	
    @Column(name="FECHAINICIO")
    private String fechaInicio;
    
    @Column(name="FECHAFIN")
    private String fechaFin;
    
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="usuario_id")
	@JsonIgnoreProperties(value="coleccion")
    private Usuario usuario;

	
	//private List<Image> imagenesLentes;
	
	@OneToMany( mappedBy = "coleccion",cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value="coleccion")
	private List<Modelo> modelos;

    @Column(name="DESCRIPCIONLENTES")
	private String descripcionLentes;
    
	@OneToMany( mappedBy = "coleccion",cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value="coleccion")
	private List<Material> materiales;
	

	@Column(name="LANZADO")
    private boolean lanzado;
    
    @Column(name="RUTAS")
    private String rutas;
    
    @Column(name="NEGOCIADO")
    private boolean negociado;
	

	
	public Coleccion(String caracteristicas, String fechaInicio, String fechaFin, Usuario usuario, List<Modelo> modelos,
			String descripcionLentes, List<Material> materiales, boolean lanzado, String rutas, boolean negociado) {
		super();
		this.caracteristicas = caracteristicas;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.usuario = usuario;
		this.modelos = modelos;
		this.descripcionLentes = descripcionLentes;
		this.materiales = materiales;
		this.lanzado = lanzado;
		this.rutas = rutas;
		this.negociado = negociado;
	}


	public Coleccion(String caracteristicas,String descripcionLentes, String fechaInicio, String fechaFin) {
        super();
        this.caracteristicas = caracteristicas;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcionLentes = descripcionLentes;
    }
	

    public Coleccion() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}


	public String getDescripcionLentes() {
		return descripcionLentes;
	}
	public void setDescripcionLentes(String descripcionLentes) {
		this.descripcionLentes = descripcionLentes;
	}
    public List<Modelo> getModelos() {
        return modelos;
    }
    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }
    
    
    public List<Material> getMateriales() {
		return materiales;
	}

	public void setMateriales(List<Material> materiales) {
		this.materiales = materiales;
	}

	public boolean isLanzado() {
		return lanzado;
	}

	public void setLanzado(boolean lanzado) {
		this.lanzado = lanzado;
	}

	public String getRutas() {
		return rutas;
	}

	public void setRutas(String rutas) {
		this.rutas = rutas;
	}

	public boolean isNegociado() {
		return negociado;
	}

	public void setNegociado(boolean negociado) {
		this.negociado = negociado;
	}
}
