package com.fintbank.app.Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Javier Ramirez
 */
@Entity
@Table(name = "dispositivo", catalog = "postgres", schema = "public")
public class Dispositivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "estado")
    private Short estado;
    
    @Column(name = "secuencia")
    private Integer secuencia;
    
    @Column(name = "identificador")
    private String identificador;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "marca")
    private String marca;
    
    @Column(name = "codigoenlace")
    private String codigoenlace;
    
    @Column(name = "creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creado;
    
    /*@JsonIgnoreProperties(value = {"dispositivoList"})
    @JoinColumn(name = "usuario_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;*/
    
    @PrePersist
    private void prePersist() {
    	this.creado = new Date();
    }

    public Dispositivo() {
    }

    public Dispositivo(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getEstado() {
        return estado;
    }

    public void setEstado(Short estado) {
        this.estado = estado;
    }

    public Integer getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Integer secuencia) {
        this.secuencia = secuencia;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCodigoenlace() {
        return codigoenlace;
    }

    public void setCodigoenlace(String codigoenlace) {
        this.codigoenlace = codigoenlace;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }
    
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
    		return true;
    	}
    	if(!(obj instanceof Dispositivo)) {
    		return false;
    	}
    	Dispositivo d = (Dispositivo) obj;
    	return this.id != null && this.id.equals(d.getId());
	}

    /*public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object obj) {
    	if(this == obj) {
    		return true;
    	}
    	if(!(obj instanceof Usuario)) {
    		return false;
    	}
    	Usuario u = (Usuario) obj;
    	return this.id != null && this.id.equals(u.getId());
    }*/   
}