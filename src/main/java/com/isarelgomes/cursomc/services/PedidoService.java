package com.isarelgomes.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isarelgomes.cursomc.dao.PedidoDAO;
import com.isarelgomes.cursomc.domain.Pedido;
import com.isarelgomes.cursomc.services.execptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoDAO repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Id inválido: " + id + "tipo :" +Pedido.class));
	}
	
	

}
