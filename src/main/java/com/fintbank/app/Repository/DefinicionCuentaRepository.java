package com.fintbank.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fintbank.app.Entity.DefinicionCuenta;

@Repository
public interface DefinicionCuentaRepository extends JpaRepository<DefinicionCuenta, Long> {

}
