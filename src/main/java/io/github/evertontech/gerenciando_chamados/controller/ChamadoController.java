package io.github.evertontech.gerenciando_chamados.controller;

import io.github.evertontech.gerenciando_chamados.dto.entrada.ChamadoEntradaDTO;
import io.github.evertontech.gerenciando_chamados.dto.saida.detalhe.ChamadoDetalheSaidaDTO;
import io.github.evertontech.gerenciando_chamados.model.entity.Chamado;
import io.github.evertontech.gerenciando_chamados.service.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/chamados")
public class ChamadoController {

    @Autowired
    ChamadoService chamadoService;

    @PostMapping
    public ChamadoDetalheSaidaDTO criar(@RequestBody ChamadoEntradaDTO dto) {
        return chamadoService.criar(dto);
    }

    @GetMapping("/{id}")
    public Optional<ChamadoDetalheSaidaDTO> obterPorId(@PathVariable Long id) {
        return chamadoService.obterPorId(id);
    }

    @PutMapping("/{id}")
    public ChamadoDetalheSaidaDTO atualizar(@RequestBody ChamadoEntradaDTO dto, @PathVariable Long id) {
        return chamadoService.atualizar(dto, id);
    }

}
