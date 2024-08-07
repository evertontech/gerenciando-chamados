package io.github.evertontech.gerenciando_chamados.controller;

import io.github.evertontech.gerenciando_chamados.model.entity.Tecnico;
import io.github.evertontech.gerenciando_chamados.model.repository.TecnicoRepository;
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
    public Tecnico criar(@RequestBody Tecnico tecnico) {
        return tecnicoService.criar(tecnico);
    }

    @GetMapping
    public Iterable<Tecnico> listarTodos() {
        return tecnicoService.listar();
    }

    @GetMapping(path = "/{id}")
    public Optional<Tecnico> obterPorId(@PathVariable Long id) {
        return tecnicoService.listarPorId(id);
    }

    @PutMapping(path = "/{id}")
    public Tecnico atualizar(@RequestBody Tecnico tecnico, @PathVariable Long id) {
        return tecnicoService.atualizar(tecnico, id);
    }

    @DeleteMapping(path = "/{id}")
    public void deletar(@PathVariable Long id) {
        tecnicoService.deletar(id);
    }
}
