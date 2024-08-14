package io.github.evertontech.gerenciando_chamados.dto.saida.detalhe;

import io.github.evertontech.gerenciando_chamados.model.entity.CategoriaDeChamado;

public class CategoriaDeChamadoDetalheSaidaDTO {

    private Long id;

    private String nome;

    private String descricao;

    static public CategoriaDeChamadoDetalheSaidaDTO paraDto(CategoriaDeChamado entidade) {
        var dto = new CategoriaDeChamadoDetalheSaidaDTO();
        dto.setId(entidade.getId());
        dto.setNome(entidade.getNome());
        dto.setDescricao(entidade.getDescricao());
        return dto;
    }

    public CategoriaDeChamadoDetalheSaidaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
