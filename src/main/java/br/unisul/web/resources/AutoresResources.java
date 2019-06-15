package br.unisul.web.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.unisul.web.domain.Autores;
import br.unisul.web.services.AutoresService;

@RestController
@RequestMapping(value = "/autores")
public class AutoresResources {
	
	@Autowired
	private AutoresService autoresService;
	//inserir
	@RequestMapping (method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Autores obj){
		obj = autoresService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//lista todos
	
	@RequestMapping (method = RequestMethod.GET)
	public ResponseEntity<List<Autores>> findAll() {
		List<Autores> lista = autoresService.findAll();
		return ResponseEntity.ok().body(lista);
	

}
}
