package io.github.evertontech.gerenciando_chamados.dto.entrada;

import io.github.evertontech.gerenciando_chamados.model.entity.CategoriaDeChamado;
import io.github.evertontech.gerenciando_chamados.model.entity.Chamado;
import io.github.evertontech.gerenciando_chamados.model.entity.Tecnico;
import jakarta.validation.constraints.NotBlank;

public class ChamadoEntradaDTO {

    private String titulo;

    private String descricao;

    @NotBlank
    private String status;

    @NotBlank
    private String prioridade;

    private Long tecnicoId;

    private Long categoriaDeChamadoId;

    static public Chamado paraEntidade(ChamadoEntradaDTO dto, Long id, Tecnico tecnico,  CategoriaDeChamado categoriaDeChamado) {
        var entidade = new Chamado();
        entidade.setId(id);
        entidade.setTitulo(dto.getTitulo());
        entidade.setDescricao(dto.getDescricao());
        entidade.setStatus(dto.getStatus());
        entidade.setPrioridade(dto.prioridade);
        entidade.setTecnico(tecnico);
        entidade.setCategoria(categoriaDeChamado);
        return entidade;
    }

    static public Chamado paraEntidade(ChamadoEntradaDTO dto, Tecnico tecnico,  CategoriaDeChamado categoriaDeChamado) {
        return paraEntidade(dto, null, tecnico, categoriaDeChamado);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public Long getTecnicoId() {
        return tecnicoId;
    }

    public void setTecnicoId(Long tecnicoId) {
        this.tecnicoId = tecnicoId;
    }

    public Long getCategoriaDeChamadoId() {
        return categoriaDeChamadoId;
    }

    public void setCategoriaDeChamadoId(Long categoriaDeChamadoId) {
        this.categoriaDeChamadoId = categoriaDeChamadoId;
    }
}
