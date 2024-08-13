package io.github.evertontech.gerenciando_chamados.controller;

import io.github.evertontech.gerenciando_chamados.dto.entrada.CategoriaChamadoEntradaDTO;
import io.github.evertontech.gerenciando_chamados.dto.saida.CategoriaChamadoSaidaDTO;
import io.github.evertontech.gerenciando_chamados.dto.saida.CategoriaChamadoSaidaListaDTO;
import io.github.evertontech.gerenciando_chamados.model.entity.CategoriaChamado;
import io.github.evertontech.gerenciando_chamados.service.CategoriaChamadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/categorias-de-chamado")
public class CategoriaChamadoController {

    @Autowired
    CategoriaChamadoService categoriaChamadoService;

    @PostMapping
    public CategoriaChamado criar(@RequestBody @Valid CategoriaChamadoEntradaDTO dto) {
        return categoriaChamadoService.criar(dto);
    }

    @GetMapping
    public Iterable<CategoriaChamadoSaidaListaDTO> listar() {
        return categoriaChamadoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<CategoriaChamadoSaidaDTO> obterPorId(@PathVariable Long id) {
        return categoriaChamadoService.obterPorId(id);
    }

    @PutMapping("/{id}")
    public CategoriaChamado atualizar(@RequestBody CategoriaChamadoEntradaDTO dto, @PathVariable Long id) {
        return categoriaChamadoService.atualizar(dto, id);
    }

    @DeleteMapping(path = "/{id}")
    public void deletar(@PathVariable Long id) {
        categoriaChamadoService.deletar(id);
    }
}
