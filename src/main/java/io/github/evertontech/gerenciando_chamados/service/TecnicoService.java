package io.github.evertontech.gerenciando_chamados.service;

import io.github.evertontech.gerenciando_chamados.dto.entrada.TecnicoEntradaDTO;
import io.github.evertontech.gerenciando_chamados.model.entity.Tecnico;
import io.github.evertontech.gerenciando_chamados.model.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    TecnicoRepository tecnicoRepository;

    public Tecnico criar(Tecnico dto) {
        return tecnicoRepository.save(dto);
    }

    public Iterable<Tecnico> listar() {
        return tecnicoRepository.findAll();
    }

    public Optional<Tecnico> listarPorId(Long id) {
        return tecnicoRepository.findById(id);
    }

    public Tecnico atualizar(Tecnico tecnico, Long id) {
        tecnico.setId(id);
        return tecnicoRepository.save(tecnico);
    }

    public void deletar(Long id) {
        tecnicoRepository.deleteById(id);
    }
}
