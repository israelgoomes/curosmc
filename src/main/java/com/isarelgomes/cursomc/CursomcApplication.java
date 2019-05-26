package com.isarelgomes.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.isarelgomes.cursomc.dao.CategoriaDao;
import com.isarelgomes.cursomc.dao.CidadeDAO;
import com.isarelgomes.cursomc.dao.ClienteDAO;
import com.isarelgomes.cursomc.dao.EnderecoDAO;
import com.isarelgomes.cursomc.dao.EstadoDAO;
import com.isarelgomes.cursomc.dao.ProdutoDao;
import com.isarelgomes.cursomc.domain.Categoria;
import com.isarelgomes.cursomc.domain.Cidade;
import com.isarelgomes.cursomc.domain.Cliente;
import com.isarelgomes.cursomc.domain.Endereco;
import com.isarelgomes.cursomc.domain.Estado;
import com.isarelgomes.cursomc.domain.Produto;
import com.isarelgomes.cursomc.domain.enums.TipoCliente;


//a interface CommandLinerRuner permite implementar um método auxiliar(o run logo abaixo) para executar alguma ação quando a aplicação iniciar
@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	//criando uma depêndencia
	@Autowired
	private CategoriaDao categoriaDao;
	@Autowired
	private ProdutoDao produtoDao;
	@Autowired
	private EstadoDAO estadoDao;
	@Autowired
	private CidadeDAO cidadeDao;
	@Autowired
	private ClienteDAO clienteDao;
	@Autowired
	private EnderecoDAO enderecoDao;
	
	 
	
	
	
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
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, " Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		//dizendo quais cidades são associados com determinado estado
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		cidadeDao.saveAll(Arrays.asList(c1, c2, c3));
		estadoDao.saveAll(Arrays.asList(est1, est2));
		
		//Cliente cli1 = new Cliente(null, "Israel gomes", "rael_goomes@hotmail.com", "45628523801", TipoCliente.PESSOAFISICA);
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteDao.saveAll(Arrays.asList(cli1));
		enderecoDao.saveAll(Arrays.asList(e1, e2));
	}
	
	

}
