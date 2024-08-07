package io.github.evertontech.gerenciando_chamados.controller;

import io.github.evertontech.gerenciando_chamados.model.entity.CategoriaChamado;
import io.github.evertontech.gerenciando_chamados.model.repository.CategoriaChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/categorias-de-chamado")
public class CategoriaChamadoController {

    @Autowired
    CategoriaChamadoRepository categoriaChamadoRepository;

    @PostMapping
    public CategoriaChamado criar(@RequestBody CategoriaChamado categoriaChamado) {
        return categoriaChamadoRepository.save(categoriaChamado);
    }

    @GetMapping
    public Iterable<CategoriaChamado> listar() {
        return categoriaChamadoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<CategoriaChamado> obterPorId(@PathVariable Long id) {
        return categoriaChamadoRepository.findById(id);
    }

    @PutMapping("/{id}")
    public CategoriaChamado atualizar(@RequestBody CategoriaChamado categoriaChamado, @PathVariable Long id) {
        categoriaChamado.setId(id);
        return categoriaChamadoRepository.save(categoriaChamado);
    }

    @DeleteMapping(path = "/{id}")
    public void deletar(@PathVariable Long id) {
        categoriaChamadoRepository.deleteById(id);
    }
}
