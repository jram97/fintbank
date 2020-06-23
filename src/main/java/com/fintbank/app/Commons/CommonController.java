package com.fintbank.app.Commons;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.fintbank.app.Auth.JwtProvider;
import com.fintbank.app.Commons.CommonService;
import com.fintbank.app.Entity.Usuario;
import com.fintbank.app.Service.UsuarioService;

public class CommonController<E, S extends CommonService<E>> {

	@Autowired
	private JwtProvider jwtProvider;

	@Autowired
	protected S service;

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> detalle(@PathVariable Long id) {
		Optional<E> entity = service.findById(id);
		if (!entity.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(entity.get());
	}

	@PostMapping
	public ResponseEntity<?> guardar(@Valid @RequestBody E entity, @RequestHeader("Authorization") String token) {

		if (token != null) {
			String alias = jwtProvider.getUserNameFromJwtToken(token.split(" ")[1]);
			Usuario user = usuarioService.findByAlias(alias);
			if (user.getRoleId().getNombre() == "ROLE_ADM") {
				E entityNew = service.save(entity);
				return ResponseEntity.status(HttpStatus.CREATED).body(entityNew);
			}
			return new ResponseEntity<>("Role Not Allowed", HttpStatus.FORBIDDEN);
		} else {
			return new ResponseEntity<>("Missing Token", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id, @RequestHeader("Authorization") String token) {

		if (token != null) {
			String alias = jwtProvider.getUserNameFromJwtToken(token.split(" ")[1]);
			Usuario user = usuarioService.findByAlias(alias);
			if (user.getRoleId().getNombre() == "ROLE_ADM" || user.getRoleId().getNombre() == "ROLE_BNK") {
				service.deleteById(id);
				return ResponseEntity.noContent().build();
			} else {
				return new ResponseEntity<>("Role Not Allowed", HttpStatus.FORBIDDEN);
			}
		} else {
			return new ResponseEntity<>("Missing Token", HttpStatus.BAD_REQUEST);
		}
	}
}
