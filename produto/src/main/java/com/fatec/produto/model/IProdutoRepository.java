package com.fatec.produto.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IProdutoRepository extends JpaRepository <Produto, Long>{

}
