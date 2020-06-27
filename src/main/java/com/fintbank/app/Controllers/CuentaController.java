package com.fintbank.app.Controllers;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fintbank.app.Auth.JwtProvider;
import com.fintbank.app.Commons.CommonController;
import com.fintbank.app.Entity.Cuenta;
import com.fintbank.app.Entity.DefinicionCuenta;
import com.fintbank.app.Entity.RelacionCuenta;
import com.fintbank.app.Entity.TipoTransaccion;
import com.fintbank.app.Entity.TransaccionCuenta;
import com.fintbank.app.Entity.Usuario;
import com.fintbank.app.Entity.DTO.TransaccionDTO;
import com.fintbank.app.Service.CuentaService;
import com.fintbank.app.Service.DefinicionCuentaService;
import com.fintbank.app.Service.RelacionCuentaService;
import com.fintbank.app.Service.TipoTransaccionService;
import com.fintbank.app.Service.TransaccionCuentaService;
import com.fintbank.app.Service.UsuarioService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("ws/cuenta")
public class CuentaController extends CommonController<Cuenta, CuentaService> {

	@Autowired
	private JwtProvider jwtProvider;
	
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private RelacionCuentaService relacionCuentaService;

	@Autowired
	private TransaccionCuentaService transaccionCuentaService;

	@Autowired
	private DefinicionCuentaService definicionCuentaService;

	@Autowired
	private TipoTransaccionService tipoTransaccionService;

	/** ONLY DEVELOPER AFTER DELETE */
	@PutMapping("/sumar/{id}")
	public ResponseEntity<?> sumarSaldo(@Valid @RequestBody Cuenta cuenta, @PathVariable Long id) {
		Optional<Cuenta> cuentaExists = this.service.findById(id);
		cuentaExists.get().setSaldo(cuenta.getSaldo());
		this.service.save(cuentaExists.get());
		return ResponseEntity.ok(cuentaExists);
	}

	@PostMapping("/definicion-cuenta/{id}")
	public ResponseEntity<?> agregarDefinicionCuenta(@Valid @RequestBody Cuenta cuenta, @PathVariable Long id) {
		Optional<DefinicionCuenta> definicionExist = definicionCuentaService.findById(id);

		if (!definicionExist.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Cuenta cuentaNew = cuenta;
		cuentaNew.setNumero(cuenta.getNumero());
		cuentaNew.setCorrelativooperaciones(1);
		cuentaNew.setDefinicion(definicionExist.get());

		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cuentaNew));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Cuenta cuenta, @PathVariable Long id) {
		Optional<Cuenta> cuentaExists = this.service.findById(id);

		if (!cuentaExists.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Cuenta cuentaNew = cuentaExists.get();
		cuentaNew.setNumero(cuenta.getNumero());
		cuentaNew.setCorrelativooperaciones((cuentaNew.getCorrelativooperaciones() + 1));

		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(this.service.save(cuentaNew)));
	}

	@PutMapping("/cambiar-estado/{id}")
	public ResponseEntity<?> cambiarEstado(@Valid @RequestBody Cuenta cuenta, @PathVariable Long id) {
		Optional<Cuenta> cuentaExists = this.service.findById(id);

		if (!cuentaExists.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Cuenta cuentaNew = cuentaExists.get();
		cuentaNew.setEstado(cuenta.getEstado());

		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cuentaNew));
	}

	@PutMapping("/enviar/{cuentade}/{cuentapara}/{tipoenvio}/{tiporecibo}")
	public ResponseEntity<?> sumarMonto(@Valid @RequestBody Cuenta cuenta, @PathVariable String cuentade,
			@PathVariable String cuentapara, @PathVariable Long tipoenvio, @PathVariable Long tiporecibo) {

		Optional<Cuenta> cuentaExists = this.service.findByNumero(cuentade);
		HashMap<String, String> errs = new HashMap<>();
		errs.put("errs", "No cuentas con suficientes fondos");
		errs.put("code", "409");

		if (!cuentaExists.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Cuenta cuentaNew = cuentaExists.get();

		if ((cuentaExists.get().getSaldo() - cuenta.getSaldo()) >= 0.0) {
			cuentaNew.setSaldo(new BigDecimal(cuentaExists.get().getSaldo() - cuenta.getSaldo())
					.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
			cuentaNew.setCorrelativooperaciones((cuentaNew.getCorrelativooperaciones() + 1));

			Optional<Cuenta> cuentaExist = this.service.findByNumero(cuentapara);

			if (!cuentaExist.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			Cuenta cuentaNews = cuentaExist.get();

			if (cuentaExist.get().getDefinicion().getMaximosaldo() >= (cuentaExist.get().getSaldo() + cuenta.getSaldo())) {
				cuentaNews.setSaldo(new BigDecimal(cuentaExist.get().getSaldo() + cuenta.getSaldo())
						.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				cuentaNews.setCorrelativooperaciones((cuentaNews.getCorrelativooperaciones() + 1));

				RelacionCuenta rCuentae = relacionCuentaService.findByCuenta(cuentaExists.get());
				RelacionCuenta rCuentar = relacionCuentaService.findByCuenta(cuentaExist.get());

				Optional<TipoTransaccion> te = tipoTransaccionService.findById(tipoenvio);
				Optional<TipoTransaccion> tr = tipoTransaccionService.findById(tiporecibo);

				Cuenta envia = this.service.save(cuentaNew);
				Cuenta recibe = this.service.save(cuentaNews);

				TransaccionCuenta tc = new TransaccionCuenta();
				tc.setTipoEnvio(te.get());
				tc.setTipoRecibe(tr.get());
				tc.setMonto(new BigDecimal(cuenta.getSaldo()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				tc.setReferencia("132654");
				tc.setEnvia(envia);
				tc.setRecibe(recibe);

				HashMap<String, Object> response = new HashMap<>();
				response.put("transaccion", transaccionCuentaService.save(tc));

				return ResponseEntity.status(HttpStatus.CREATED).body(response);

			} else {
				HashMap<String, String> err = new HashMap<>();
				err.put("errs", "La cuenta a la cual desea abonar, sobrepasa el limite debido al tipo de cuenta");
				err.put("code", "409");

				return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
			}
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(errs);
		}
	}
	
	@PutMapping("/transaccion")
	public ResponseEntity<?> hacerTransaccion(@Valid @RequestBody TransaccionDTO transaccionDTO, @RequestHeader("Authorization") String token) {

		String alias = jwtProvider.getUserNameFromJwtToken(token.split(" ")[1]);
		Usuario user = usuarioService.findByAlias(alias);


		System.out.println(user.getAlias());
		
		System.out.println(token);
		
		System.out.println(alias);
		
		Optional<Cuenta> cuentaExists = this.service.findByNumero(user.getCuenta().getNumero());
		HashMap<String, String> errs = new HashMap<>();
		errs.put("errs", "No cuentas con suficientes fondos");
		errs.put("code", "409");

		if (!cuentaExists.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Cuenta cuentaNew = cuentaExists.get();

		if ((cuentaExists.get().getSaldo() - transaccionDTO.getMonto()) >= 0.0) {
			cuentaNew.setSaldo(new BigDecimal(cuentaExists.get().getSaldo() - transaccionDTO.getMonto())
					.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
			cuentaNew.setCorrelativooperaciones((cuentaNew.getCorrelativooperaciones() + 1));

			Optional<Cuenta> cuentaExist = this.service.findByNumero(transaccionDTO.getPara());

			if (!cuentaExist.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			Cuenta cuentaNews = cuentaExist.get();

			if (cuentaExist.get().getDefinicion().getMaximosaldo() >= (cuentaExist.get().getSaldo() + transaccionDTO.getMonto())) {
				cuentaNews.setSaldo(new BigDecimal(cuentaExist.get().getSaldo() + transaccionDTO.getMonto())
						.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				cuentaNews.setCorrelativooperaciones((cuentaNews.getCorrelativooperaciones() + 1));

				Optional<TipoTransaccion> te = tipoTransaccionService.findById(transaccionDTO.getTipoEnvio());
				Optional<TipoTransaccion> tr = tipoTransaccionService.findById(transaccionDTO.getTipoRecibo());

				Cuenta envia = this.service.save(cuentaNew);
				Cuenta recibe = this.service.save(cuentaNews);

				TransaccionCuenta tc = new TransaccionCuenta();
				tc.setTipoEnvio(te.get());
				tc.setTipoRecibe(tr.get());
				tc.setMonto(new BigDecimal(transaccionDTO.getMonto()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				tc.setReferencia("132654");
				tc.setEnvia(envia);
				tc.setRecibe(recibe);

				HashMap<String, Object> response = new HashMap<>();
				response.put("transaccion", transaccionCuentaService.save(tc));

				return ResponseEntity.status(HttpStatus.CREATED).body(response);

			} else {
				HashMap<String, String> err = new HashMap<>();
				err.put("errs", "La cuenta a la cual desea abonar, sobrepasa el limite debido al tipo de cuenta");
				err.put("code", "409");

				return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
			}
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(errs);
		}
	}
	
}