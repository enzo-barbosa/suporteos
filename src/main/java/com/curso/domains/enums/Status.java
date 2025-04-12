package com.curso.domains.enums;

public enum Status {
    INATIVO(0, "INATIVO"), ATIVO(1, "ATIVO");
    private Integer id;
    private String situacao;

    Status(Integer id, String situacao) {
        this.id = id;
        this.situacao = situacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public static Status toEnum(Integer id) {
        if(id==null) return null; // Se o ID for nulo, retorna nulo.
        for(Status x : Status.values()) { // Percorre todos os valores do enum (INATIVO e ATIVO).
            if(id.equals(x.getId())) { // Se o ID bater com algum enum...
                return x; // Retorna o enum correspondente.
            }
        }
        throw new IllegalArgumentException("Status Inválido"); // Se não achar, lança erro.
    }
}
