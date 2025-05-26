package com.curso.resources;

import com.curso.domains.dtos.GrupoProdutoDTO;
import com.curso.domains.dtos.ProdutoDTO;
import com.curso.domains.enums.GrupoProduto;
import com.curso.domains.enums.Produto;
import com.curso.services.GrupoProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // gerencia as requisições http e envia respostas no formato json
@RequestMapping(value = "/grupoproduto") //define a URL base para esse controlador
public class GrupoProdutoResource {

    @Autowired
    private GrupoProdutoService grupoProdutoService;

    @GetMapping //exemplo - http://localhost:8080/produto
    public ResponseEntity<List<GrupoProdutoDTO>> findAll() {
        return ResponseEntity.ok().body(grupoProdutoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GrupoProdutoDTO> findById(@PathVariable Integer id) {
        GrupoProduto obj = this.grupoProdutoService.findbyId(id);
        return ResponseEntity.ok().body(new GrupoProdutoDTO(obj));
    }}
