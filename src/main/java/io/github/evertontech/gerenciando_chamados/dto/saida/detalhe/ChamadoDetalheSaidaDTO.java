package io.github.evertontech.gerenciando_chamados.dto.saida.detalhe;

import io.github.evertontech.gerenciando_chamados.dto.saida.resumo.CategoriaDeChamadoResumoSaidaDTO;
import io.github.evertontech.gerenciando_chamados.dto.saida.resumo.TecnicoResumoSaidaDTO;
import io.github.evertontech.gerenciando_chamados.model.entity.Chamado;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ChamadoDetalheSaidaDTO {
    private Long id;

    private String titulo;

    private String descricao;

    private String status;

    private String prioridade;

    private LocalDate dataAbertura;

    private LocalDate dataFechamento;

    private TecnicoResumoSaidaDTO tecnico;

    private CategoriaDeChamadoResumoSaidaDTO categoria;

    static public ChamadoDetalheSaidaDTO paraDto(Chamado entidade) {
        var dto = new ChamadoDetalheSaidaDTO();
        dto.setId(entidade.getId());
        dto.setTitulo(entidade.getTitulo());
        dto.setDescricao(entidade.getDescricao());
        dto.setStatus(entidade.getStatus());
        dto.setPrioridade(entidade.getPrioridade());
        dto.setDataAbertura(entidade.getDataAbertura());
        dto.setDataFechamento(entidade.getDataFechamento());
        dto.setTecnico(TecnicoResumoSaidaDTO.paraDto(entidade.getTecnico()));
        dto.setCategoria(CategoriaDeChamadoResumoSaidaDTO.paraDto(entidade.getCategoria()));
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

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDate getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDate dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public TecnicoResumoSaidaDTO getTecnico() {
        return tecnico;
    }

    public void setTecnico(TecnicoResumoSaidaDTO tecnico) {
        this.tecnico = tecnico;
    }

    public CategoriaDeChamadoResumoSaidaDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDeChamadoResumoSaidaDTO categoria) {
        this.categoria = categoria;
    }
}
