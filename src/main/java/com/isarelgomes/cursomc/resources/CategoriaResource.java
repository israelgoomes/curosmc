package com.isarelgomes.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isarelgomes.cursomc.domain.Categoria;
import com.isarelgomes.cursomc.services.CategoriaService;

//tornando a classe um controlador rest
@RestController
//que responde por esse endpoint (/categorias), que também será a rota da url
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	//atribuindo o verbo http para get, poderia ser post, delete. etc
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	//o list faz a conversão automatica de algum dado para formato json
	public ResponseEntity<?> find(@PathVariable Integer id) {
		//acessando o serviço para buscar uma cetegotia com determinado id
		Categoria obj = service.buscar(id);
				//retornando se a resposta ocorreu tudo bem
		//o método ok diz que a operação ocorreu com sucesso
		//
				return ResponseEntity.ok().body(obj);
	}

}
