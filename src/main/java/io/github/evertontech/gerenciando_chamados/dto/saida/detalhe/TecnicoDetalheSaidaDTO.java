package io.github.evertontech.gerenciando_chamados.dto.saida.detalhe;

import io.github.evertontech.gerenciando_chamados.enums.Especialidade;
import io.github.evertontech.gerenciando_chamados.model.entity.Tecnico;

import java.time.LocalDate;

public class TecnicoDetalheSaidaDTO {

    private Long id;

    private String nome;

    private String email;

    private LocalDate criacaoCadastro;

    private Especialidade especialidade;

    static public TecnicoDetalheSaidaDTO paraDTO(Tecnico entidade) {
        var dto = new TecnicoDetalheSaidaDTO();
        dto.setId(entidade.getId());
        dto.setNome(entidade.getNome());
        dto.setEmail(entidade.getEmail());
        dto.setCriacaoCadastro(entidade.getCriacaoCadastro());
        dto.setEspecialidade(entidade.getEspecialidade());
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCriacaoCadastro() {
        return criacaoCadastro;
    }

    public void setCriacaoCadastro(LocalDate criacaoCadastro) {
        this.criacaoCadastro = criacaoCadastro;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
}
