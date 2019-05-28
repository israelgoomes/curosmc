package com.isarelgomes.cursomc.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	/*ResponseEntity: significa representar toda a resposta HTTP. Você pode controlar qualquer coisa que aconteça: código de status, cabeçalhos e corpo.*/
	/*  o @PathVariable é utilizado quando o valor da variável é passada diretamente na URL, 
	 * mas não como um parametro que você passa após o sinal de interrogação (?) mas sim quando o valor faz parte da url.*/
	public ResponseEntity<Categoria> find(@PathVariable Integer id) {
		//acessando o serviço para buscar uma cetegotia com determinado id
		Categoria obj = service.find(id);
				//retornando se a resposta ocorreu tudo bem
		//o método ok diz que a operação ocorreu com sucesso
		//
				return ResponseEntity.ok().body(obj);
	}
	//inserindo
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria obj) {
		obj = service.insert(obj);
		//a uri serve para retornar o novo caminho para a categoria criada, por exemplo existe a categorias/1 e categorias/2, ao inserir uma nova essa função vai dar como resposta a categorias/3
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Categoria obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
}
