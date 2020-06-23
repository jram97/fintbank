package com.fintbank.app.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fintbank.app.Entity.Cuenta;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

	public Optional<Cuenta> findByNumero(String numero);
	
}
