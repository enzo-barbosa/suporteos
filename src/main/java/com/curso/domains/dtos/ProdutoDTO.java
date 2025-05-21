package com.curso.domains.dtos;

import com.curso.domains.enums.Produto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProdutoDTO {
    private long idProduto;

    @NotNull(message = "O campo descrição não pode ser nulo")
    @NotBlank(message = "O campo descrição não pode estar vazio")
    private String descricao;

    @NotNull(message = "O campo saldoEstoque não pode ser nulo")
    @Digits(integer = 15, fraction = 3)
    private BigDecimal saldoEstoque;

    @NotNull(message = "O campo valorUnitario não pode ser nulo")
    @Digits(integer = 15, fraction = 3)
    private BigDecimal valorUnitario;

    @NotNull(message = "O campo valorEstoque não pode ser nulo")
    @Digits(integer = 15, fraction = 3)
    private BigDecimal valorEstoque;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro = LocalDate.now();

    @NotNull(message = "O campo grupoProduto não pode ser nulo")
    private int grupoProduto;

    private String descricaoGrupoProduto;

    private int status;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Produto produto) {
        this.idProduto = produto.getIdProduto();
        this.descricao = produto.getDescricao();
        this.saldoEstoque = produto.getSaldoEstoque();
        this.valorUnitario = produto.getValorUnitario();
        this.valorEstoque = produto.getValorEstoque();
        this.dataCadastro = produto.getDataCadastro();
        this.grupoProduto = produto.getGrupoProduto().getId();
        this.descricaoGrupoProduto = produto.getGrupoProduto().getDescricao();;
        this.status = produto.getStatus().getId();
    }

    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
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

    @NotNull(message = "O campo saldoEstoque não pode ser nulo")
    @NotBlank(message = "O campo saldoEstoque não pode estar vazio")
    public BigDecimal getSaldoEstoque() {
        return saldoEstoque;
    }

    @NotNull(message = "O campo saldoEstoque não pode ser nulo")
    @Digits(integer = 15, fraction = 3)
    public void setSaldoEstoque(BigDecimal saldoEstoque) {
        this.saldoEstoque = saldoEstoque;
    }

    @NotNull(message = "O campo valorUnitario não pode ser nulo")
    @Digits(integer = 15, fraction = 3)
    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    @NotNull(message = "O campo valorUnitario não pode ser nulo")
    @Digits(integer = 15, fraction = 3)
    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @NotNull(message = "O campo valorEstoque não pode ser nulo")
    @Digits(integer = 15, fraction = 3)
    public BigDecimal getValorEstoque() {
        return valorEstoque;
    }

    @NotNull(message = "O campo valorEstoque não pode ser nulo")
    @Digits(integer = 15, fraction = 3)
    public void setValorEstoque(BigDecimal valorEstoque) {
        this.valorEstoque = valorEstoque;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @NotNull(message = "O campo Grupo Produto é requerido")
    public int getGrupoProduto() {
        return grupoProduto;
    }

    @NotNull(message = "O campo Grupo Produto é requerido")
    public void setGrupoProduto(int grupoProduto) {
        this.grupoProduto = grupoProduto;
    }

    public String getDescricaoGrupoProduto() {
        return descricaoGrupoProduto;
    }

    public void setDescricaoGrupoProduto(String descricaoGrupoProduto) {
        this.descricaoGrupoProduto = descricaoGrupoProduto;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
