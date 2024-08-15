package io.github.evertontech.gerenciando_chamados.dto.entrada;

import io.github.evertontech.gerenciando_chamados.model.entity.CategoriaDeChamado;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

public class CategoriaDeChamadoEntradaDTO {

    @NotBlank
    @Max(35)
    private String nome;

    @Max(150)
    private String descricao;

    static public CategoriaDeChamado paraEntidade(CategoriaDeChamadoEntradaDTO dto) {
        return paraEntidade(dto, null);
    }

    static public CategoriaDeChamado paraEntidade(CategoriaDeChamadoEntradaDTO dto, Long id) {
        var entidade = new CategoriaDeChamado();
        entidade.setId(id);
        entidade.setNome(dto.getNome());
        entidade.setDescricao(dto.getDescricao());
        return entidade;
    }

    public CategoriaDeChamadoEntradaDTO() {

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
