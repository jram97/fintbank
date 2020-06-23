package com.fintbank.app.Controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fintbank.app.Commons.CommonController;
import com.fintbank.app.Entity.TipoCanalFisico;
import com.fintbank.app.Service.TipoCanalFisicoService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("ws/tipo-canal")
public class TipoCanalFisicoController extends CommonController<TipoCanalFisico, TipoCanalFisicoService> {

	public ResponseEntity<?> editar(@RequestBody TipoCanalFisico tipoCanalFisico, @PathVariable Long id) {
		Optional<TipoCanalFisico> tipoCanal = this.service.findById(id);
		if (!tipoCanal.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		TipoCanalFisico nuevoRegistro = tipoCanal.get();

		nuevoRegistro.setCodigo(tipoCanalFisico.getCodigo());
		nuevoRegistro.setNombre(tipoCanalFisico.getNombre());

		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(nuevoRegistro));
	}

}
