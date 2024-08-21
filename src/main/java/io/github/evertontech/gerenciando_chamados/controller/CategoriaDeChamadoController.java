package io.github.evertontech.gerenciando_chamados.controller;

import io.github.evertontech.gerenciando_chamados.dto.entrada.CategoriaDeChamadoEntradaDTO;
import io.github.evertontech.gerenciando_chamados.dto.saida.detalhe.CategoriaDeChamadoDetalheSaidaDTO;
import io.github.evertontech.gerenciando_chamados.dto.saida.resumo.CategoriaDeChamadoResumoSaidaDTO;
import io.github.evertontech.gerenciando_chamados.service.CategoriaDeChamadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/categorias-de-chamado")
public class CategoriaDeChamadoController {

    @Autowired
    CategoriaDeChamadoService categoriaDeChamadoService;

    @PostMapping
    public CategoriaDeChamadoDetalheSaidaDTO criar(@RequestBody @Valid CategoriaDeChamadoEntradaDTO dto) {
        return categoriaDeChamadoService.criar(dto);
    }

    @GetMapping
    public Iterable<CategoriaDeChamadoResumoSaidaDTO> listar() {
        return categoriaDeChamadoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<CategoriaDeChamadoDetalheSaidaDTO> obterPorId(@PathVariable Long id) {
        return categoriaDeChamadoService.obterPorId(id);
    }

    @PutMapping("/{id}")
    public CategoriaDeChamadoDetalheSaidaDTO atualizar(@RequestBody CategoriaDeChamadoEntradaDTO dto, @PathVariable Long id) {
        return categoriaDeChamadoService.atualizar(dto, id);
    }

    @DeleteMapping(path = "/{id}")
    public Optional<CategoriaDeChamadoDetalheSaidaDTO> deletar(@PathVariable Long id) {
        return categoriaDeChamadoService.deletar(id);
    }
}
