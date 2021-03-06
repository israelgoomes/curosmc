package com.isarelgomes.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

//declarando que a classe será uma identidade do jpa
@Entity
//a interface serializable diz que os objetos da classe poderão ser convertidos para um sequência de bytes, para poderem ser gravados em arquivos, trafegar em redes, etc.

public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	
	/*--------------------CONSTRUTORES-------------------------------------*/
	//criando um construtor vazio
	public Categoria() {
	}
	//criando um construtor parametrizado
	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}	
	/*----------------------------FIM CONSTRUTORES---------------------------------*/
	
	
	
	/*--------ATRIBUTOS--------*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	/*Uma categoria terá varios produtos, siginifica que a categoria terá dentro dela uma lista d eprodutos
	 (produtos é o nome dado no diagrama (Produto é a classe)	*/
	
	//fazendo uma referencia json. que deve ser feita do lado que deseja vir os objetos associados
	@ManyToMany(mappedBy="categorias") // fazendo referência ao mapeamento já construido em produto, "categorias" vem da lista criado em produtos.
	private List<Produto> produtos = new ArrayList<>();
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
	
	public List<Produto> getProdutos(){
		return produtos;
	}
	
	public void setProdutos(List<Produto> produtos){
		this.produtos = produtos;
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
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	/*------------------FIM HASHCODE E EQUALS--------------------------*/

}
	
	

	


