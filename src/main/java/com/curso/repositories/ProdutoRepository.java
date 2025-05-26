package com.curso.repositories;

import com.curso.domains.enums.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // Indicação pro framework trata-la corretamente
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // JpaRepository<> recebe dois parâmetros que são a classe que o repository irá gerenciar e o tipo de dado da chave da classe
    // Porque Long ao invés de long informado no id da classe GrupoProduto? O Spring Data preferem a versão wrapper por conta da flxibilidade de trabalho

    Optional<Produto> findByCodigoBarra(String codigoBarra);

}
