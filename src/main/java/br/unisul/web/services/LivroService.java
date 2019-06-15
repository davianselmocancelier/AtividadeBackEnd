package br.unisul.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.web.domain.Livro;
import br.unisul.web.repositories.LivroRepository;

@Service
public class LivroService {


	@Autowired
	private LivroRepository rep1;

	// BUSCA POR ID
	public Livro find(Integer id) {
		Optional<Livro> obj = rep1.findById(id);
		return obj.orElse(null);
	}

	// FAZ INSERÇÃO
	public Livro insert(Livro obj) {
		obj.setId(null);
		return rep1.save(obj);
	}

	// ATUALIZAR
	public Livro update(Livro obj) {
		find(obj.getId());
		return rep1.save(obj);
	}

	// DELETAR
	public void delete(Integer id) {
		find(id);
		rep1.deleteById(id);
	}

	// LISTAR TODAS
	public List<Livro> findAll() {
		return rep1.findAllByOrderById();
	}
}
