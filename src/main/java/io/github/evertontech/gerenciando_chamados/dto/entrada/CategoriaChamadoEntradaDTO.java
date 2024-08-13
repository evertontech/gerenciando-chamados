package io.github.evertontech.gerenciando_chamados.dto.entrada;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

public class CategoriaChamadoEntradaDTO {

    @NotBlank
    @Max(35)
    private String nome;

    @Max(150)
    private String descricao;

    public CategoriaChamadoEntradaDTO() {

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
