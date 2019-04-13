package com.isarelgomes.cursomc.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//tornando a classe um controlador rest
@RestController
//que responde por esse endpoint (/categorias)
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	//atribuindo o verbo http, no saco para get, poderia ser post, delete. etc
	@RequestMapping(method=RequestMethod.GET)
	public String listar() {
		return "Rest está funcionando !";
	}

}
