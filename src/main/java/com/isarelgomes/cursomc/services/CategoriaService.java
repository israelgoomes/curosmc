package com.isarelgomes.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isarelgomes.cursomc.dao.CategoriaDao;
import com.isarelgomes.cursomc.domain.Categoria;
import com.isarelgomes.cursomc.services.execptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	//o Autowride serve para o spring instanciar automaticamente uma independencia dentro de uma classe
	@Autowired
	private CategoriaDao repo;
	
	
	//criando uma operação capaz de buscar uma categoria por código.
	public Categoria buscar(Integer id) {
		//criando um objeto para fazer a busca no banco de dados através do id
		Optional<Categoria> obj = repo.findById(id);
		//retornando o objeto ou se não existir, uma exceção
				return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id + ", Tipo: "
						+ Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
		
	}
	
}
