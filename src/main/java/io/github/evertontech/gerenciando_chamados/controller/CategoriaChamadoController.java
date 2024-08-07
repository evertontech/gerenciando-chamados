package io.github.evertontech.gerenciando_chamados.controller;

import io.github.evertontech.gerenciando_chamados.model.entity.CategoriaChamado;
import io.github.evertontech.gerenciando_chamados.service.CategoriaChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/categorias-de-chamado")
public class CategoriaChamadoController {

    @Autowired
    CategoriaChamadoService categoriaChamadoService;

    @PostMapping
    public CategoriaChamado criar(@RequestBody CategoriaChamado categoriaChamado) {
        return categoriaChamadoService.criar(categoriaChamado);
    }

    @GetMapping
    public Iterable<CategoriaChamado> listar() {
        return categoriaChamadoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<CategoriaChamado> obterPorId(@PathVariable Long id) {
        return categoriaChamadoService.obterPorId(id);
    }

    @PutMapping("/{id}")
    public CategoriaChamado atualizar(@RequestBody CategoriaChamado categoriaChamado, @PathVariable Long id) {
        return categoriaChamadoService.atualizar(categoriaChamado, id);
    }

    @DeleteMapping(path = "/{id}")
    public void deletar(@PathVariable Long id) {
        categoriaChamadoService.deletar(id);
    }
}
