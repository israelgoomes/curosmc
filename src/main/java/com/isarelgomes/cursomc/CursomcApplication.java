package com.isarelgomes.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.isarelgomes.cursomc.dao.CategoriaDao;
import com.isarelgomes.cursomc.dao.ProdutoDao;
import com.isarelgomes.cursomc.domain.Categoria;
import com.isarelgomes.cursomc.domain.Produto;


//a interface CommandLinerRuner permite implementar um método auxiliar(o run logo abaixo) para executar alguma ação quando a aplicação iniciar
@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	//criando uma depêndencia
	@Autowired
	private CategoriaDao categoriaDao;
	@Autowired
	private ProdutoDao produtoDao;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	//adicionado após da um implementes mode, pois a aplicação ficara em vermelhor, clicar no erro do canto e implementar esse modo
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.0);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		//associando os produtos que pertencem a informatica, e os que pertencem a escritório
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		//chamando o objeto criado a cima, e fazendo uma salvamento no banco, utilizando um o Arrays.asList para criar lista automaticamente.
		categoriaDao.saveAll(Arrays.asList(cat1, cat2));
		produtoDao.saveAll(Arrays.asList(p1, p2, p3));
		
	}

}
