package com.curso.domains.dtos;

import com.curso.domains.enums.GrupoProduto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class GrupoProdutoDTO {
    private int id;

    @NotNull // Define que o atributo não pode ser nulo
    @NotBlank // Define que o atributo não pode ter somente espaços em branco (tem que ter algum conteúde dentro)
    private String descricao;
    private int status;

    public GrupoProdutoDTO() {
    }

    public GrupoProdutoDTO(GrupoProduto grupoProduto) {
        this.id = grupoProduto.getId();
        this.descricao = grupoProduto.getDescricao();
        this.status = grupoProduto.getStatus().getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull(message = "O campo descrição não pode ser nulo")
    @NotBlank(message = "O campo descrição não pode estar vazio")
    public String getDescricao() {
        return descricao;
    }

    @NotNull(message = "O campo descrição não pode ser nulo")
    @NotBlank(message = "O campo descrição não pode estar vazio")
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;   
    }
}
