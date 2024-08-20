package io.github.evertontech.gerenciando_chamados.dto.saida.resumo;

import io.github.evertontech.gerenciando_chamados.model.entity.Tecnico;

public class TecnicoResumoSaidaDTO {
    private Long id;

    private String nome;

    static public TecnicoResumoSaidaDTO paraDto(Tecnico entidade) {
        var dto = new TecnicoResumoSaidaDTO();
        dto.setId(entidade.getId());
        dto.setNome(entidade.getNome());
        return dto;
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
