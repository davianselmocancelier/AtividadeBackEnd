package br.unisul.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.unisul.web.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer > {
	
	@Transactional(readOnly=true)
	public List<Livro> findAllByOrderById();
}
