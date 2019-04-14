package com.isarelgomes.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isarelgomes.cursomc.dao.CategoriaDao;
import com.isarelgomes.cursomc.domain.Categoria;

@Service
public class CategoriaService {
	//o Autowride serve para o spring instanciar automaticamente uma independencia dentro de uma classe
	@Autowired
	private CategoriaDao repo;
	
	
	//criando uma operação capaz de buscar uma categoria por código.
	public Categoria buscar(Integer id) {
		//criando um objeto para fazer a busca no banco de dados através do id
		Optional<Categoria> obj = repo.findById(id);
		//retornando o objeto ou null caso vazio
				return obj.orElse(null);
		
		
	}
	
}