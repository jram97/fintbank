package com.fintbank.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fintbank.app.Entity.ControlCuenta;

@Repository
public interface ControlCuentaRepository extends JpaRepository<ControlCuenta, Long> {

}
