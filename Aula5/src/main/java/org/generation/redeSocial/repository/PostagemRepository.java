package org.generation.redeSocial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import org.generation.redeSocial.model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {	
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo); //default
	/*public List<Postagem> findAllByTemaContainingIgnoreCase (String tema);                  //realmente deve estar em model?
	public List<Postagem> findAllByUsuarioLoginContainingIgnoreCase (String usuarioLogin); //realmente deve estar em model? */
} 
