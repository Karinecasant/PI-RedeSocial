package org.generation.blogPessoal.repository;

import java.util.List;

import org.generation.blogPessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //trata-se de outra interface
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);
	/*findAllByTitulo=busca pelo titulo (nome atributo entidade titulo); 
	Containing (=like do SQL); IgnoreCase = não levar consideração min e maiuscula)*/
	
}
