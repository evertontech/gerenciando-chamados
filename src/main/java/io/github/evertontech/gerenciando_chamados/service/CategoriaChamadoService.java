package io.github.evertontech.gerenciando_chamados.service;

import io.github.evertontech.gerenciando_chamados.model.entity.CategoriaChamado;
import io.github.evertontech.gerenciando_chamados.model.repository.CategoriaChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaChamadoService {

    @Autowired
    CategoriaChamadoRepository categoriaChamadoRepository;


    public CategoriaChamado criar(CategoriaChamado categoriaChamado) {
        return categoriaChamadoRepository.save(categoriaChamado);
    }

    public Iterable<CategoriaChamado> listar() {
        return categoriaChamadoRepository.findAll();
    }

    public Optional<CategoriaChamado> obterPorId(Long id) {
        return categoriaChamadoRepository.findById(id);
    }

    public CategoriaChamado atualizar(CategoriaChamado categoriaChamado, Long id) {
        categoriaChamado.setId(id);
        return categoriaChamadoRepository.save(categoriaChamado);
    }

    public void deletar(Long id) {
        categoriaChamadoRepository.deleteById(id);
    }
}
