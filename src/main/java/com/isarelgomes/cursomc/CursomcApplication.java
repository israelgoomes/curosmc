package com.isarelgomes.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.isarelgomes.cursomc.dao.CategoriaDao;
import com.isarelgomes.cursomc.domain.Categoria;


//a interface CommandLinerRuner permite implementar um método auxiliar(o run logo abaixo) para executar alguma ação quando a aplicação iniciar
@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	//criando uma depêndencia
	@Autowired
	private CategoriaDao categoriaDao;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	//adicionado após da um implementes mode, pois a aplicação ficara em vermelhor, clicar no erro do canto e implementar esse modo
	@Override
	public void run(String... args) throws Exception {
		
		
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		//chamando o objeto criado a cima, e fazendo uma salvamento no banco, utilizando um o Arrays.asList para criar lista automaticamente.
		categoriaDao.saveAll(Arrays.asList(cat1, cat2));
		
	}

}
