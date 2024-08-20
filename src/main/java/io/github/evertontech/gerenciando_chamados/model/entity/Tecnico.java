package io.github.evertontech.gerenciando_chamados.model.entity;

import io.github.evertontech.gerenciando_chamados.enums.Especialidade;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDate criacaoCadastro;

    private Especialidade especialidade;

    private String email;

    private String senha;

    public Tecnico() {
        this.setCriacaoCadastro(LocalDate.now());
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public Especialidade getEspecialidade() {
        return this.especialidade;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setCriacaoCadastro(LocalDate criacaoCadastro) {
        this.criacaoCadastro = criacaoCadastro;
    }

    public LocalDate getCriacaoCadastro() {
        return this.criacaoCadastro;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
