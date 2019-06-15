package br.unisul.web.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.unisul.web.config.dtos.AutoresDTO;
import br.unisul.web.config.dtos.LivroDto;
import br.unisul.web.domain.Autores;
import br.unisul.web.domain.Livro;
import br.unisul.web.services.AutoresService;
import br.unisul.web.services.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResources {

	@Autowired
	private LivroService service;

	@Autowired
	private AutoresService AutoresService;

	// LISTAR AutoresS DE UM Livro
	@RequestMapping(value = "/{LivroId}/Autores", method = RequestMethod.GET)
	public ResponseEntity<List<AutoresDTO>> findAutoress(@PathVariable Integer livroId) {
		List<Autores> list = AutoresService.findByAutores(livroId);
		List<AutoresDTO> listDto = list.stream().map(obj -> new AutoresDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	// BUSCAR POR ID
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Livro> find(@PathVariable Integer id) {
		Livro obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Livro obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Livro obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	// EXCLUIR
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	// LISTAR TODAS
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<LivroDto>> findAll() {
		List<Livro> lista = service.findAll();

		List<LivroDto> listDto = new ArrayList<LivroDto>();

		for (Livro e : lista) {
			listDto.add(new LivroDto(e));
		}

		return ResponseEntity.ok().body(listDto);
	}

}
