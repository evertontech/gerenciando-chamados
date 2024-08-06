package io.github.evertontech.gerenciando_chamados.controller;

import io.github.evertontech.gerenciando_chamados.model.entity.CategoriaChamado;
import io.github.evertontech.gerenciando_chamados.model.repository.CategoriaChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
