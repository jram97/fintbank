package com.fintbank.app.Entity.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fintbank.app.Entity.Usuario;

public class JwtResponse {

	private String token;
	
	private String type = "Bearer";

	@JsonIgnoreProperties(value = { "roleId", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	private Usuario usuario;

	public JwtResponse(String jwt, Usuario user) {
		this.token = jwt;
		this.usuario = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}