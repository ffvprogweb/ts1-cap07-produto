package com.fatec.produto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.produto.model.IProdutoRepository;
import com.fatec.produto.model.Produto;

@Service
public class ProdutoServico implements IProdutoServico{
	@Autowired
	IProdutoRepository repository;
	@Override
	public Produto cadastrar(Produto p) {
		return repository.save(p);
	}

}
