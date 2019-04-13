package com.isarelgomes.cursomc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isarelgomes.cursomc.domain.Categoria;

@Repository
//a interface JpaRepository é capaz de acessar os dados com base no tipo que for passado
/*o Objeto categoriaDao será capaz de realizar operações de acesso a dados(inserir, atualizar, excluir, etc) referente ao objeto categoria, que
 está mapeado com a tabela categoria do banco de dados*/
public interface CategoriaDao extends JpaRepository<Categoria, Integer> {

	
}
