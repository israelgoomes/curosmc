package com.isarelgomes.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/*--------------------CONSTRUTORES-------------------------------------*/
	
	public Produto() {}
	
	public Produto(Integer id, String nome, Double preco) {
		//super() invoca o constructor, sem argumentos, da classe derivada (pai).
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}
	/*----------------------------FIM CONSTRUTORES---------------------------------*/

	
	
	
	/*--------ATRIBUTOS--------*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double preco;
	
	//Criando um mapeamento, que é uma tabela do banco de dados que faz a ponte entre as duas tabelas que terão conexão
	@ManyToMany
	@JoinTable(name = "PRODUTO_CATEGORIA", //DEFININDO O NOME DA TABELA INTERMEDIARIA ONDE FICA AS PK'S E FK'S
	joinColumns = @JoinColumn(name = "produto_id"),	//DEFININDO O NOME DO CAMPOR DA  TABELA CORRESPONDENTE AO CÓDIGO DO PRODUTODO(CHAVE ESTRANGEIRA	
	inverseJoinColumns = @JoinColumn(name = "categoria_id") //DEFININDO A OUTRA CHAVE ESTRANGEIRA QUE É A CATEGORIA.
			)
	private List<Categoria> categorias = new ArrayList<>();
	/*-------------------FIM ATRIBUTOS-----------------------------*/

	
	
	/*=-------MÉTODOS------------*/
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
	
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public List<Categoria> getCategorias(){
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	
	
	/*------------------FIM MÉTODOS -----------------------------*/
	
	

	/*---------------- HashCOde e equals------------------------*/	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	/*------------------FIM HASHCODE E EQUALS--------------------------*/

	
	
	
	

}
