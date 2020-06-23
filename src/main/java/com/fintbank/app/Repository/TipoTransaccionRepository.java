package com.fintbank.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fintbank.app.Entity.TipoTransaccion;

@Repository
public interface TipoTransaccionRepository extends JpaRepository<TipoTransaccion, Long> {

}
