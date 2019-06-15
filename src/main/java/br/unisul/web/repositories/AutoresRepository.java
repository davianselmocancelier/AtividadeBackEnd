package br.unisul.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.unisul.web.domain.Autores;

@Repository
public interface AutoresRepository extends JpaRepository<Autores, Integer>{
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Autores obj WHERE obj.livro.id = :livroId ORDER BY obj.nome")
	public List<Autores> findAutores(@Param("livroId") Integer livro_id);
	

}