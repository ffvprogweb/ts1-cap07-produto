package com.fatec.produto.servico;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.produto.model.Produto;
import com.fatec.produto.service.ProdutoServico;
@SpringBootTest
class Req01CadastrarProdutoTests {
	@Autowired
	ProdutoServico servico;
	@Test
	void ct01_cadastrar_produto_com_sucesso() {
		// dado que o usuario inseriu as informações de produto
		Produto produto = new Produto();
		produto.setDescricao("Eletrobomba 110v para maquina de lavar");
		produto.setCategoria("maquinad de lavar");
		produto.setCusto("51.66");
		produto.setQuantidadeNoEstoque("12");
		Produto p = servico.cadastrar(produto);
		assertTrue(produto.equals(p));
	}

}
