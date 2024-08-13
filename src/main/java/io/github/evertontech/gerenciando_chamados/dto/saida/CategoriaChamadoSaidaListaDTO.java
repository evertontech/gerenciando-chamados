package io.github.evertontech.gerenciando_chamados.dto.saida;

import io.github.evertontech.gerenciando_chamados.model.entity.CategoriaChamado;

public class CategoriaChamadoSaidaListaDTO {

    private Long id;

    private String nome;

    static public CategoriaChamadoSaidaListaDTO paraDto(CategoriaChamado entidade) {
        var dto = new CategoriaChamadoSaidaListaDTO();
        dto.setId(entidade.getId());
        dto.setNome(entidade.getNome());
        return dto;
    }

    public CategoriaChamadoSaidaListaDTO() {
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
}
