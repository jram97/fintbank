package com.fintbank.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fintbank.app.Entity.TipoCanalFisico;

@Repository
public interface TipoCanalFisicoRepository extends JpaRepository<TipoCanalFisico, Long> {

}
