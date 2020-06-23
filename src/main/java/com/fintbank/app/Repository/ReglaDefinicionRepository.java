package com.fintbank.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fintbank.app.Entity.ReglaDefinicion;

@Repository
public interface ReglaDefinicionRepository extends JpaRepository<ReglaDefinicion, Long> {

}
