package br.unisul.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.web.domain.Autores;
import br.unisul.web.repositories.AutoresRepository;

@Service
public class AutoresService {
@Autowired
 private AutoresRepository rep;
	@Autowired
	private LivroService livroService;
	
	public List<Autores> findByAutores(Integer livroId){
		
		return rep.findAutores(livroId);
				
	}

	public Autores insert(Autores obj) {
		obj.setId(null);
		obj.setLivro(livroService.find(obj.getLivro().getId()));
		obj = rep.save(obj);
		return obj;
		
	}
	
	public List<Autores> findAll(){
		return rep.findAll();
	}
}
