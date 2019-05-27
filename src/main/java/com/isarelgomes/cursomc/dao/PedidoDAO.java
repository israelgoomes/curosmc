package com.isarelgomes.cursomc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isarelgomes.cursomc.domain.Pedido;

@Repository
public interface PedidoDAO extends JpaRepository<Pedido, Integer> {

}
