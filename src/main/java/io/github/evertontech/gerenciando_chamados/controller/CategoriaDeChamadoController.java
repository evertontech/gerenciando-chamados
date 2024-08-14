package io.github.evertontech.gerenciando_chamados.controller;

import io.github.evertontech.gerenciando_chamados.dto.entrada.CategoriaDeChamadoEntradaDTO;
import io.github.evertontech.gerenciando_chamados.dto.saida.detalhe.CategoriaDeChamadoDetalheSaidaDTO;
import io.github.evertontech.gerenciando_chamados.dto.saida.resumo.CategoriaDeChamadoResumoSaidaDTO;
import io.github.evertontech.gerenciando_chamados.model.entity.CategoriaDeChamado;
import io.github.evertontech.gerenciando_chamados.service.CategoriaDeChamadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/categorias-de-chamado")
public class CategoriaDeChamadoController {

    @Autowired
    CategoriaDeChamadoService categoriaChamadoService;

    @PostMapping
    public CategoriaDeChamado criar(@RequestBody @Valid CategoriaDeChamadoEntradaDTO dto) {
        return categoriaChamadoService.criar(dto);
    }

    @GetMapping
    public Iterable<CategoriaDeChamadoResumoSaidaDTO> listar() {
        return categoriaChamadoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<CategoriaDeChamadoDetalheSaidaDTO> obterPorId(@PathVariable Long id) {
        return categoriaChamadoService.obterPorId(id);
    }

    @PutMapping("/{id}")
    public CategoriaDeChamado atualizar(@RequestBody CategoriaDeChamadoEntradaDTO dto, @PathVariable Long id) {
        return categoriaChamadoService.atualizar(dto, id);
    }

    @DeleteMapping(path = "/{id}")
    public void deletar(@PathVariable Long id) {
        categoriaChamadoService.deletar(id);
    }
}
