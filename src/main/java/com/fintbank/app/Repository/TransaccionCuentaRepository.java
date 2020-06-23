package com.fintbank.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fintbank.app.Entity.TransaccionCuenta;

@Repository
public interface TransaccionCuentaRepository extends JpaRepository<TransaccionCuenta, Long> {

}
