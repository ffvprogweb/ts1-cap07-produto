package com.fatec.produto.persistencia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.produto.model.IProdutoRepository;
import com.fatec.produto.model.Produto;

@SpringBootTest
class Req01CadastrarProdutoTests {
	@Autowired
	IProdutoRepository repository;

	@Test
	void ct01_catadastrar_produto_com_sucesso() {
		// dado que o usuario inseriu as informações de produto
		Produto produto = new Produto();
		produto.setDescricao("Eletrobomba 110v para maquina de lavar");
		produto.setCategoria("maquinad de lavar");
		produto.setCusto("51.66");
		produto.setQuantidadeNoEstoque("12");
		//quando confirma a operação de cadastro
		repository.save(produto);
		//entao as informações ficam disponiveis para consulta
		assertEquals(1, repository.count());
	}

	@Test
	void ct02_catadastrar_produto_com_descricao_branco() {
		try {
			// dado que o usuario inseriu informações invalidas de produto
			Produto produto = new Produto();
			produto.setDescricao("");
			//quando confirma a operação
			//então retorna mensagem erro
		} catch (IllegalArgumentException e) {
			assertEquals("A descrição não deve estar em branco", e.getMessage());
		}
	}
	@Test
	void ct03_catadastrar_produto_com_descricao_null() {
		try {
			// dado que o usuario inseriu as informações de produto
			Produto produto = new Produto();
			produto.setDescricao(null);
		} catch (IllegalArgumentException e) {
			assertEquals("A descrição não deve estar em branco", e.getMessage());
		}
	}
	@Test
	void ct04_catadastrar_produto_com_categoria_branco() {
		try {
			// dado que o usuario inseriu as informações de produto
			Produto produto = new Produto();
			produto.setCategoria("");
		} catch (IllegalArgumentException e) {
			assertEquals("A categoria não deve estar em branco", e.getMessage());
		}
	}
}
