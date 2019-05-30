package com.isarelgomes.cursomc.dto;

import com.isarelgomes.cursomc.domain.Categoria;

public class CategoriaDTO {
//essa classe é utilizada exclusivamente para definir os dados que quero trafegar quando acessar categoria.
	
	private Integer id;
	private String nome;
	
	public CategoriaDTO() {
}
	
	//construtor feito para receber o objeto correspondente da entidade de dominio.
	public CategoriaDTO(Categoria obj) {
		id = obj.getId();
		nome = obj.getNome();
	}

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
