package io.github.evertontech.gerenciando_chamados.dto.entrada;

import io.github.evertontech.gerenciando_chamados.enums.Especialidade;
import io.github.evertontech.gerenciando_chamados.model.entity.Tecnico;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class TecnicoEntradaDTO {

    @Max(32)
    @NotBlank
    private String nome;

    @Max(32)
    @NotBlank
    private Especialidade especialidade;

    @Email
    private String email;

    @Min(8)
    @Max(20)
    @NotBlank
    private String senha;

    public TecnicoEntradaDTO() {

    }

    static public Tecnico paraEntidade(TecnicoEntradaDTO dto, Long id) {
        var entidade = new Tecnico();
        entidade.setId(id);
        entidade.setNome(dto.getNome());
        entidade.setEspecialidade(dto.getEspecialidade());
        entidade.setEmail(dto.getEmail());
        entidade.setSenha(dto.getSenha());
        return entidade;
    }

    static public Tecnico paraEntidade(TecnicoEntradaDTO dto) {
        return paraEntidade(dto, null);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
