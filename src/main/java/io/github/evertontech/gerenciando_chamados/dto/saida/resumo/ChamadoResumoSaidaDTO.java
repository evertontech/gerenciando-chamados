package io.github.evertontech.gerenciando_chamados.dto.saida.resumo;

import io.github.evertontech.gerenciando_chamados.dto.entrada.ChamadoEntradaDTO;
import io.github.evertontech.gerenciando_chamados.model.entity.CategoriaDeChamado;
import io.github.evertontech.gerenciando_chamados.model.entity.Chamado;
import io.github.evertontech.gerenciando_chamados.model.entity.Tecnico;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;

public class ChamadoResumoSaidaDTO {
    private Long id;
    private String titulo;
    private String status;
    private String prioridade;
    private String nomeTecnico;
    private String nomeCategoria;

    static public ChamadoResumoSaidaDTO paraDto(Chamado entidade) {
        var dto = new ChamadoResumoSaidaDTO();
        dto.setId(entidade.getId());
        dto.setTitulo(entidade.getTitulo());
        dto.setStatus(entidade.getStatus());
        dto.setPrioridade(entidade.getPrioridade());
        dto.setNomeTecnico(entidade.getTecnico().getNome());
        dto.setNomeCategoria(entidade.getCategoria().getNome());
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public String getNomeTecnico() {
        return nomeTecnico;
    }

    public void setNomeTecnico(String nomeTecnico) {
        this.nomeTecnico = nomeTecnico;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
}
