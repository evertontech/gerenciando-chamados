package io.github.evertontech.gerenciando_chamados.dto.saida.resumo;

import io.github.evertontech.gerenciando_chamados.model.entity.CategoriaDeChamado;

public class CategoriaDeChamadoResumoSaidaDTO {

    private Long id;

    private String nome;

    static public CategoriaDeChamadoResumoSaidaDTO paraDto(CategoriaDeChamado entidade) {
        var dto = new CategoriaDeChamadoResumoSaidaDTO();
        dto.setId(entidade.getId());
        dto.setNome(entidade.getNome());
        return dto;
    }

    public CategoriaDeChamadoResumoSaidaDTO() {
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
