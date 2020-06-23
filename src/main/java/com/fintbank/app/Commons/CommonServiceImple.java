package com.fintbank.app.Commons;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fintbank.app.Commons.CommonService;

public class CommonServiceImple<E, R extends JpaRepository<E, Long>> implements CommonService<E> {

	@Autowired
	protected R repository;

	@Transactional(readOnly = true, timeout = 15)
	@Override
	public List<E> findAll() {
		return repository.findAll();
	}

	@Transactional(readOnly = true, timeout = 15)	
	@Override
	public Optional<E> findById(Long id) {
		return repository.findById(id);
	}

	@Transactional(timeout = 15)
	@Override
	public E save(E entity) {
		return repository.save(entity);
	}

	@Transactional(timeout = 10)	
	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
