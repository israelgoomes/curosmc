package com.isarelgomes.cursomc.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.isarelgomes.cursomc.domain.Categoria;
import com.isarelgomes.cursomc.dto.CategoriaDTO;
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


	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<Categoria> list = service.findAll();
		//percorrendo a lista e para cada elemento da lista instanciar o DTO correspondente, o stream percorrer os elementos da lista e o map aplica uma operação para cada um desses elementos.
		List<CategoriaDTO> listDto = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
				return ResponseEntity.ok().body(listDto);
	}
	
	
	//criando um método para configurar a quantidade de itens que apareceram, e outras coisas da página.
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<CategoriaDTO>> findPage(
			//a configuração é feita através do requestParam
			@RequestParam(value="page", defaultValue="0") Integer page, 
			//recomendado 24, pois é multipli de 1, 2, 3 e 4
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction){
		
		Page<Categoria> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<CategoriaDTO> listDto = list.map(obj -> new CategoriaDTO(obj));
		return ResponseEntity.ok().body(listDto);
		
	}
}
