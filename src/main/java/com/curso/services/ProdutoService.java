package com.curso.services;

import com.curso.domains.dtos.GrupoProdutoDTO;
import com.curso.domains.dtos.ProdutoDTO;
import com.curso.domains.enums.Produto;
import com.curso.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepo;

    public List<ProdutoDTO> findAll() {

        //retorna uma lista de ProdutoDTO
        return produtoRepo.findAll().stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
    }

    public Produto findbyId(Long id) {
        Optional<Produto> obj = produtoRepo.findById(id);
        return obj.orElse(null);
    }
}
