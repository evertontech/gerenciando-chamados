package io.github.evertontech.gerenciando_chamados.controller;

import io.github.evertontech.gerenciando_chamados.dto.entrada.TecnicoEntradaDTO;
import io.github.evertontech.gerenciando_chamados.dto.saida.detalhe.TecnicoDetalheSaidaDTO;
import io.github.evertontech.gerenciando_chamados.dto.saida.resumo.TecnicoResumoSaidaDTO;
import io.github.evertontech.gerenciando_chamados.model.entity.Tecnico;
import io.github.evertontech.gerenciando_chamados.service.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/tecnicos")
public class TecnicoController {

    @Autowired
    TecnicoService tecnicoService;

    @PostMapping
    public TecnicoDetalheSaidaDTO criar(@RequestBody TecnicoEntradaDTO dto) {
        return tecnicoService.criar(dto);
    }

    @GetMapping
    public Iterable<TecnicoResumoSaidaDTO> listarTodos() {
        return tecnicoService.listar();
    }

    @GetMapping(path = "/{id}")
    public Optional<TecnicoResumoSaidaDTO> obterPorId(@PathVariable Long id) {
        return tecnicoService.obterPorId(id);
    }

    @PutMapping(path = "/{id}")
    public TecnicoDetalheSaidaDTO atualizar(@RequestBody TecnicoEntradaDTO tecnico, @PathVariable Long id) {
        return tecnicoService.atualizar(tecnico, id);
    }

    @DeleteMapping(path = "/{id}")
    public void deletar(@PathVariable Long id) {
        tecnicoService.deletar(id);
    }
}
