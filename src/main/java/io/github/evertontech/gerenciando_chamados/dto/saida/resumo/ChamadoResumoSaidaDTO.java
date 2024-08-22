package io.github.evertontech.gerenciando_chamados.dto.saida.resumo;

import io.github.evertontech.gerenciando_chamados.model.entity.CategoriaDeChamado;
import io.github.evertontech.gerenciando_chamados.model.entity.Tecnico;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;

public class ChamadoResumoSaidaDTO {
    private Long id;


    private String titulo;


    private String descricao;


    private String status;


    private String prioridade;


    private LocalDateTime dataAbertura;


    private LocalDateTime dataFechamento;


    private Tecnico tecnico;


    private CategoriaDeChamado categoria;

}
