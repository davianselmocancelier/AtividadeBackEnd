package br.unisul.web.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.web.domain.Autores;
import br.unisul.web.domain.Livro;
import br.unisul.web.repositories.AutoresRepository;
import br.unisul.web.repositories.LivroRepository;

@Service
public class DbService {

	@Autowired
	private LivroRepository livRep;

	@Autowired
	private AutoresRepository autRep;

	public void inicializaBancoDeDados() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Livro l1 = new Livro(15.90, "Surf");
		Livro l2 = new Livro(12.34, "Avatar");
		Livro l3 = new Livro(500.0, "Barbie");
		Livro l4 = new Livro(4.564, "Pau de arára");
		

		
		 l1 =livRep.save(l1);
		 l2 =livRep.save(l2);
		 l3 =livRep.save(l3);
		 l4 =livRep.save(l4);


		Autores a1 = new Autores(null, "João", "Masculino", 12, l1);
		Autores a2 = new Autores(null, "Maria", "Feminino", 1, l2);
		Autores a3 = new Autores(null, "Higor", "Masculino", 1, l3);
		Autores a4 = new Autores(null, "Lacas", "Feminino", 1, l4);

		autRep.saveAll(Arrays.asList(a1, a2, a3, a4));

	}

}
