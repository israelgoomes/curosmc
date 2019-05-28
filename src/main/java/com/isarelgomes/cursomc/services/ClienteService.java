package com.isarelgomes.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isarelgomes.cursomc.dao.ClienteDAO;
import com.isarelgomes.cursomc.domain.Cliente;
import com.isarelgomes.cursomc.services.execptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteDAO repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado id: " + id + "Tipo" + Cliente.class.getName()));
		
	}

}
