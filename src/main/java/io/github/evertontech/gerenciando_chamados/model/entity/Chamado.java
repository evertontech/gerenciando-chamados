package io.github.evertontech.gerenciando_chamados.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;


@Entity
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Max(50)
    @NotBlank
    private String titulo;

    @Max(150)
    @NotBlank
    private String descricao;

    @NotBlank
    private String status;

    @NotBlank
    private String prioridade;


    private LocalDate dataAbertura;

    @PastOrPresent
    private LocalDate dataFechamento;

    @ManyToOne
    private Tecnico tecnico;

    @ManyToOne
    private CategoriaDeChamado categoria;

    public Chamado() {
        this.setDataAbertura(LocalDate.now());
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getPrioridade() {
        return this.prioridade;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDate getDataAbertura() {
        return this.dataAbertura;
    }

    public void setDataFechamento(LocalDate dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public LocalDate getDataFechamento() {
        return this.dataFechamento;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Tecnico getTecnico() {
        return this.tecnico;
    }

    public void setCategoria(CategoriaDeChamado categoria) {
        this.categoria = categoria;
    }

    public CategoriaDeChamado getCategoria() {
        return this.categoria;
    }
}
