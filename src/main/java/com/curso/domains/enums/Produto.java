package com.curso.domains.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
    private Long idProduto;

    @NotBlank
    @NotNull
    private String codigoBarra;

    @NotBlank
    @NotNull
    private String descricao;

    @NotNull
    @Digits(integer = 15, fraction = 3) // Define o número de inteiros e decimais (15 inteiros e 3 casas decimais)
    private BigDecimal saldoEstoque;

    @NotNull
    @Digits(integer = 15, fraction = 3) // Define o número de inteiros e decimais (15 inteiros e 3 casas decimais)
    private BigDecimal valorUnitario;

    @NotNull
    @Digits(integer = 15, fraction = 3) // Define o número de inteiros e decimais (15 inteiros e 3 casas decimais)
    private BigDecimal valorEstoque;

    @JsonFormat(pattern = "dd/MM/yyyy") // Define o formato de data que será descrita no Json para a comunicação com o front-end.
    private LocalDate dataCadastro;

    @ManyToOne // Indica que muitos objetos da entidade Produto estão associados a um objeto da entidade GrupoProduto.
    @JoinColumn(name = "idgrupoproduto") // Define a coluna na tabela produto que será usada como chave estrangeira para se referir à tabela grupoproduto
    // O parâmetro name="idgrupoproduto" indica que a coluna no banco de dados que armazenará essa chave estrangeira se chama idgrupoproduto
    private GrupoProduto grupoProduto;

    @Enumerated(EnumType.ORDINAL) // Define que o atributo status será gravado no banco 0 ou 1 (INATIVO ou ATIVO)
    @JoinColumn(name = "status") // Define o nome do campo no banco que irá receber o valor ordinal do Enum.
    private Status status;

    public Produto() {
        this.saldoEstoque = BigDecimal.ZERO; // Estoque começa zerado
        this.valorUnitario = BigDecimal.ZERO; // Preço unitário inicial zerado
        this.valorEstoque = BigDecimal.ZERO; // Valor total do estoque zerado
        this.status = Status.ATIVO; // Define que quando gerar um novo produto ele será ATIVO
    }

    public Produto(Long idProduto,String codigoBarra, String descricao, BigDecimal saldoEstoque, BigDecimal valorUnitario, LocalDate dataCadastro, GrupoProduto grupoProduto, Status status) {
        this.idProduto = idProduto;
        this.codigoBarra = codigoBarra;
        this.descricao = descricao;
        // this.saldoEstoque = saldoEstoque;
        this.valorUnitario = valorUnitario;
        this.dataCadastro = dataCadastro;
        this.grupoProduto = grupoProduto;
        this.status = status;

        this.saldoEstoque = saldoEstoque != null ? saldoEstoque : BigDecimal.ZERO; // Se saldoEstoque for nulo, define como ZERO
        this.valorEstoque = saldoEstoque != null ? saldoEstoque.multiply(valorUnitario) : BigDecimal.ZERO; // Calcula o valor total do estoque (saldo * unitário) ou ZERO se saldo for nulo
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getSaldoEstoque() {
        return saldoEstoque;
    }

    public void setSaldoEstoque(BigDecimal saldoEstoque) {
        this.saldoEstoque = saldoEstoque;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorEstoque() {
        return valorEstoque;
    }

    public void setValorEstoque(BigDecimal valorEstoque) {
        this.valorEstoque = valorEstoque;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public GrupoProduto getGrupoProduto() {
        return grupoProduto;
    }

    public void setGrupoProduto(GrupoProduto grupoProduto) {
        this.grupoProduto = grupoProduto;
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
        Produto produto = (Produto) o;
        return idProduto == produto.idProduto && Objects.equals(descricao, produto.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduto, descricao);
    }
}
