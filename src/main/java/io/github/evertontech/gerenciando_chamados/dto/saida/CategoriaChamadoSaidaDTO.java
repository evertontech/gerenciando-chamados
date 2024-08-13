package io.github.evertontech.gerenciando_chamados.dto.saida;

import io.github.evertontech.gerenciando_chamados.model.entity.CategoriaChamado;

public class CategoriaChamadoSaidaDTO {

    private Long id;

    private String nome;

    private String descricao;

    static public CategoriaChamadoSaidaDTO paraDto(CategoriaChamado entidade) {
        var dto = new CategoriaChamadoSaidaDTO();
        dto.setId(entidade.getId());
        dto.setNome(entidade.getNome());
        return dto;
    }

    public CategoriaChamadoSaidaDTO() {
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
