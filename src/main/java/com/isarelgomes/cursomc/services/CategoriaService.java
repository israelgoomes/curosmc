package com.isarelgomes.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.isarelgomes.cursomc.dao.CategoriaDao;
import com.isarelgomes.cursomc.domain.Categoria;
import com.isarelgomes.cursomc.services.execptions.DataIntegrityException;
import com.isarelgomes.cursomc.services.execptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	//o Autowride serve para o spring instanciar automaticamente uma independencia dentro de uma classe
	@Autowired
	private CategoriaDao repo;
	
	
	//criando uma operação capaz de buscar uma categoria por código.
	public Categoria find(Integer id) {
		//criando um objeto para fazer a busca no banco de dados através do id
		Optional<Categoria> obj = repo.findById(id);
		//retornando o objeto ou se não existir, uma exceção
				return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id + ", Tipo: "
						+ Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		//id nulo para dizer que é inserção, caso contrário irá atualizar
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		
		try {
		repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir a categoria, pois existem produtos cadastrados nela.");
			
		}
		
		
		}
	
	public List<Categoria> findAll(){
		return repo.findAll();
	}
		
	//criando uma função para retornar apenas as categorias que quiser, na find page é informado a página q quer, linerPerPage é quantas linhas de página vc quer
	//@SuppressWarnings("deprecation")
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		//o pagerequest prepara as infromações para a consulta
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
		
	}
	
}
