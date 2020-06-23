package com.fintbank.app.Service;

import org.springframework.stereotype.Service;

import com.fintbank.app.Commons.CommonServiceImple;
import com.fintbank.app.Entity.Usuario;
import com.fintbank.app.Repository.UsuarioRepository;

@Service
public class UsuarioServiceImple extends CommonServiceImple<Usuario, UsuarioRepository> implements UsuarioService {

	@Override
	public Usuario findByAlias(String alias) {
		return repository.findByAlias(alias);
	}

}
