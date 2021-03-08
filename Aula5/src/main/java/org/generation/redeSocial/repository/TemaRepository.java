package org.generation.redeSocial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.generation.redeSocial.model.Tema;

public interface TemaRepository extends JpaRepository<Tema, Long> {
	public List<Tema> findAllByCategoriaContainingIgnoreCase( String categoria);
}