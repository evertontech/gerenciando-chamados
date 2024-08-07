package io.github.evertontech.gerenciando_chamados.controller;

import io.github.evertontech.gerenciando_chamados.model.entity.Tecnico;
import io.github.evertontech.gerenciando_chamados.model.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/tecnicos")
public class TecnicoController {

    @Autowired
    TecnicoRepository tecnicoRepository;

    @PostMapping
    public Tecnico criar(@RequestBody Tecnico tecnico) {
        return tecnicoRepository.save(tecnico);
    }

    @GetMapping
    public Iterable<Tecnico> obterTodos() {
        return tecnicoRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Tecnico> obterPorId(@PathVariable Long id) {
        return tecnicoRepository.findById(id);
    }

    @PutMapping(path = "/{id}")
    public Tecnico atualizar(@RequestBody Tecnico tecnico, @PathVariable Long id) {
        tecnico.setId(id);
        return tecnicoRepository.save(tecnico);
    }

    @DeleteMapping(path = "/{id}")
    public void deletar(@PathVariable Long id) {
        tecnicoRepository.deleteById(id);
    }
}
