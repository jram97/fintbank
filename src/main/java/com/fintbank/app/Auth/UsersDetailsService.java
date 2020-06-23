package com.fintbank.app.Auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fintbank.app.Entity.Usuario;
import com.fintbank.app.Service.UsuarioService;

@Service
public class UsersDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String alias) throws UsernameNotFoundException {
		Usuario usuario = usuarioService.findByAlias(alias);
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario no existente con el alias solicitado");
		}
		return userBuilder(usuario.getAlias(), passwordEncoder.encode(usuario.getClave()),
				usuario.getRoleId().getNombre());
	}

	private User userBuilder(String alias, String password, String... roles) {
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNotLocked = true;

		List<GrantedAuthority> authorities = new ArrayList<>();

		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return new User(alias, password, enabled, accountNonExpired, credentialsNonExpired, accountNotLocked,
				authorities);
	}

}
