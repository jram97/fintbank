package com.fintbank.app.Controllers;

import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fintbank.app.Auth.JwtProvider;
import com.fintbank.app.Config.Functions;
import com.fintbank.app.Entity.Cuenta;
import com.fintbank.app.Entity.DefinicionCuenta;
import com.fintbank.app.Entity.Role;
import com.fintbank.app.Entity.Usuario;
import com.fintbank.app.Entity.DTO.JwtResponse;
import com.fintbank.app.Entity.DTO.Login;
import com.fintbank.app.Entity.DTO.Register;
import com.fintbank.app.Service.CuentaService;
import com.fintbank.app.Service.DefinicionCuentaService;
import com.fintbank.app.Service.RoleService;
import com.fintbank.app.Service.UsuarioService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("ws/auth")
public class AuthController {

	@Autowired
	private JwtProvider jwtProvider;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private DefinicionCuentaService definicionCuentaService;
	
	@Autowired
	private CuentaService cuentaService;

	@PostMapping("/login")
	public ResponseEntity<?> logIn(@Valid @RequestBody Login login) {

		Usuario usuario = usuarioService.findByAlias(login.getAlias());

		if (usuario == null) {
			return new ResponseEntity<String>("Credenciales incorrectas", HttpStatus.FORBIDDEN);
		}
		if (!passwordEncoder.matches(login.getPassword(), usuario.getClave())) {
			return new ResponseEntity<String>("Credenciales incorrectas", HttpStatus.FORBIDDEN);
		}
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(login.getAlias(), login.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		Usuario user = usuario;
		user.setUltimoInicio(new Date());

		String jwt = jwtProvider.generateJwtToken(authentication);
		return ResponseEntity.ok(new JwtResponse(jwt, usuarioService.save(user)));
	}

	@PostMapping("/signin")
	public ResponseEntity<?> signIn(@Valid @RequestBody Register user) {

		Usuario usuario = usuarioService.findByAlias(user.getAlias());

		if (usuario != null) {
			return new ResponseEntity<String>("Este cuenta ya existe", HttpStatus.BAD_REQUEST);
		}

		Optional<Role> roles = roleService.findById(user.getRole());

		Usuario userToInsert = new Usuario();
		userToInsert.setAlias(user.getAlias());
		userToInsert.setClave(passwordEncoder.encode(user.getClave()));
		userToInsert.setDireccion(user.getDireccion());
		userToInsert.setNotificacion(user.getNotificacion());
		userToInsert.setAutenticacionClave(user.getAutenticacionClave());
		userToInsert.setNumeroIdentificacion(user.getNumeroIdentificacion());
		userToInsert.setRole(roles.get());
		
		Cuenta newCuenta = new Cuenta();
		Optional<DefinicionCuenta> definicionCuenta = definicionCuentaService.findById(user.getTipoDefinicion());
		newCuenta.setNumero(Functions.numeroCuenta(user.getAlias(), user.getNumeroIdentificacion()));
		newCuenta.setDefinicion(definicionCuenta.get());
		
		userToInsert.setCuenta(cuentaService.save(newCuenta));
	
		Usuario newUser = usuarioService.save(userToInsert);

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getAlias(), user.getClave()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		return ResponseEntity.ok(new JwtResponse(jwt, newUser));
	}

}
