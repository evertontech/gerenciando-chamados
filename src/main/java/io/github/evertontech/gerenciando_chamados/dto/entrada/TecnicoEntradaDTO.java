package io.github.evertontech.gerenciando_chamados.dto.entrada;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

public class TecnicoEntradaDTO {

    @Max(32)
    @NotBlank
    private String nome;

    @Max(32)
    @NotBlank
    private String especialidade;

    @Email
    private String email;

    public TecnicoEntradaDTO() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
