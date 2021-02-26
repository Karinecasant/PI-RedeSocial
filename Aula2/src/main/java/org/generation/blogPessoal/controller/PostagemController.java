package org.generation.blogPessoal.controller;

import java.util.List;

import org.generation.blogPessoal.model.Postagem;
import org.generation.blogPessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController                //Informa para o Spring que essa classe trata-se de um controle
@RequestMapping("/postagens") //Informa em qual URI essa classe será acessada
@CrossOrigin("*")            //Informa que a classe irá aceitar requisições de qualquer origem
public class PostagemController {
	
	@Autowired // Permite que todos serviços dessa interface sejam acessadas a partir do controller
	private PostagemRepository repository;
	
	@GetMapping // Se o método da requisição externa for o GET, ele vai disparar esse método abaixo
	public ResponseEntity<List<Postagem>> GetAll(){
		return ResponseEntity.ok(repository.findAll());	
	}
	
	@GetMapping("/{id}") //Mapear rota 
	public ResponseEntity<Postagem> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}") 
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping /*Criar método post, testar via postman,capturar/passar o objeto/recurso pela body (@RequestBody Postagem postagem) 
	usando o ResponseEntity, usar novo status de resposta (HttpStatus.CREATED) */
	public ResponseEntity<Postagem> post (@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}
	
	@PutMapping /*Criar método put @PutMapping, testar via postman, capturar/passar o objeto/recurso pela body (@RequestBody Postagem postagem) 
	usando o ResponseEntity, usar novo status de resposta (HttpStatus.OK) */
	public ResponseEntity<Postagem> put (@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}
	
