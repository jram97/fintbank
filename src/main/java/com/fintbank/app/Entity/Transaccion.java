package com.fintbank.app.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Javier Ramirez
 */
@Entity
@Table(name = "transaccion", catalog = "postgres", schema = "public")
public class Transaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fechahora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahora;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "identificadorvisual")
    private String identificadorvisual;

    @JsonIgnoreProperties(value = {"transaccion"}, allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransaccionCuenta> transaccioncuentaList;

    @PrePersist
    public void prePersist() {
    	this.fechahora = new Date();
    }
    
    public Transaccion() {
    	this.transaccioncuentaList = new ArrayList<>();
    }

    public Transaccion(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechahora() {
        return fechahora;
    }

    public void setFechahora(Date fechahora) {
        this.fechahora = fechahora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdentificadorvisual() {
        return identificadorvisual;
    }

    public void setIdentificadorvisual(String identificadorvisual) {
        this.identificadorvisual = identificadorvisual;
    }

    public List<TransaccionCuenta> getTransaccioncuentaList() {
        return transaccioncuentaList;
    }

    public void setTransaccioncuentaList(List<TransaccionCuenta> transaccioncuentaList) {
        this.transaccioncuentaList = transaccioncuentaList;
    }
    
    public void addTransaccionCuenta (TransaccionCuenta transaccionCuenta) {
    	this.transaccioncuentaList.add(transaccionCuenta);
    }
    
    public void deleteTransaccionCuenta (TransaccionCuenta transaccionCuenta) {
    	this.transaccioncuentaList.remove(transaccionCuenta);
    }
    
    @Override
    public boolean equals(Object obj) {
    	if(this == obj) {
    		return true;
    	}
    	if(!(obj instanceof Transaccion)) {
    		return false;
    	}
    	Transaccion t = (Transaccion) obj;
    	return this.id != null && this.id.equals(t.getId());
    }


}