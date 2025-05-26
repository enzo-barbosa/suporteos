package com.curso.domains.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity // Define a classe GrupoProduto como uma entidade do sistema
@Table(name="grupoproduto") // Indica o nome da tabela que irá ser criada no banco de dados
public class GrupoProduto {

    @Id // Define o atributo identificador da classe
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_grupoproduto") // Define a estratégia de geração de chave no banco
    private int id;

    @NotNull // Define que o atributo não pode ser nulo
    @NotBlank // Define que o atributo não pode ter somente espaços em branco (tem que ter algum conteúde dentro)
    private String descricao;

    @JsonIgnore // Impede que o atributo produtos seja serializado quando o objeto GrupoProduto for convertido em Json
    @OneToMany(mappedBy = "grupoProduto") // Define que um objeto da classe(GrupoProduto) pode estar associado a muitos objetos de outra classe (Produto)
    // O parâmetro mappedBy indica que o lado dono do relacionamento está na classe produto, no campo grupoProduto. Isso é, Produto tem uma referência ao
    // GrupoProduto, e essa chave estrangeira é usada para mapear o relacionamento
    private List<Produto> produtos = new ArrayList<>();

    @Enumerated(EnumType.ORDINAL) // Define que o atributo status será gravado no banco 0 ou 1 (INATIVO ou ATIVO)
    @JoinColumn(name = "status") // Define o nome do campo no banco que irá receber o valor ordinal do Enum
    private Status status;

    public GrupoProduto() {
        this.status = Status.ATIVO; // Define que quando gerar um novo grupoproduto ele será ATIVO
    }

    public GrupoProduto(int id, String descricao, Status status) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GrupoProduto that = (GrupoProduto) o;
        return id == that.id && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao);
    }
}
