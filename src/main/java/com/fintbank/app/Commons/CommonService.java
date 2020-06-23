package com.fintbank.app.Commons;

import java.util.List;
import java.util.Optional;

public interface CommonService<E> {

	public List<E> findAll();

	public Optional<E> findById(Long id);

	public E save(E entity);

	public void deleteById(Long id);

}
