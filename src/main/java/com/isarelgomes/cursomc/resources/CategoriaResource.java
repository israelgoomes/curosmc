package com.isarelgomes.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isarelgomes.cursomc.domain.Categoria;

//tornando a classe um controlador rest
@RestController
//que responde por esse endpoint (/categorias), que também será a rota da url
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	//atribuindo o verbo http para get, poderia ser post, delete. etc
	@RequestMapping(method=RequestMethod.GET)
	
	//o list faz a conversão automatica de algum dado para formato json
	public List<Categoria> listar() {
		
		Categoria cat1 = new Categoria(1,  "Informática");
		Categoria cat2 = new Categoria(2, "Escritório");
		
		List<Categoria> lista= new ArrayList<>();
		lista.add(cat1);
		lista.add(cat2);
		
				return lista;
	}

}
