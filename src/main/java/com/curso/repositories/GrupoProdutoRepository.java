package com.curso.repositories;

import com.curso.domains.enums.GrupoProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Indicação pro framework trata-la corretamente
public interface GrupoProdutoRepository extends JpaRepository<GrupoProduto, Integer> {
    // JpaRepository<> recebe dois parâmetros que são a classe que o repository irá gerenciar e o tipo de dado da chave da classe
    // Porque Integer ao invés de int informado no id da classe GrupoProduto? O Spring Data preferem a versão wrapper por conta da flxibilidade de trabalho


}
