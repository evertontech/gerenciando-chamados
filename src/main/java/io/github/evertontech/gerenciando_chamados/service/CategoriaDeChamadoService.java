package io.github.evertontech.gerenciando_chamados.service;

import io.github.evertontech.gerenciando_chamados.dto.entrada.CategoriaDeChamadoEntradaDTO;
import io.github.evertontech.gerenciando_chamados.dto.saida.detalhe.CategoriaDeChamadoDetalheSaidaDTO;
import io.github.evertontech.gerenciando_chamados.dto.saida.resumo.CategoriaDeChamadoResumoSaidaDTO;
import io.github.evertontech.gerenciando_chamados.model.entity.CategoriaDeChamado;
import io.github.evertontech.gerenciando_chamados.model.repository.CategoriaDeChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class CategoriaDeChamadoService {

    @Autowired
    CategoriaDeChamadoRepository categoriaDeChamadoRepository;

    public CategoriaDeChamadoDetalheSaidaDTO criar(CategoriaDeChamadoEntradaDTO dtoEntrada) {
        var entidade = CategoriaDeChamadoEntradaDTO.paraEntidade(dtoEntrada);
        categoriaDeChamadoRepository.save(entidade);
        return CategoriaDeChamadoDetalheSaidaDTO.paraDto(entidade);
    }

    public Iterable<CategoriaDeChamadoResumoSaidaDTO> listar() {
        var categorias = categoriaDeChamadoRepository.findAll();
        var stream = StreamSupport.stream(categorias.spliterator(), true);
        return stream.map(CategoriaDeChamadoResumoSaidaDTO::paraDto).toList();
    }

    public Optional<CategoriaDeChamadoDetalheSaidaDTO> obterPorId(Long id) {
        Optional<CategoriaDeChamado> pesquisa = categoriaDeChamadoRepository.findById(id);
        if (pesquisa.isPresent()) {
            var entidade = pesquisa.get();
            var dto = CategoriaDeChamadoDetalheSaidaDTO.paraDto(entidade);
            return Optional.of(dto);
        }
        return Optional.empty();
    }

    public CategoriaDeChamadoDetalheSaidaDTO atualizar(CategoriaDeChamadoEntradaDTO dto, Long id) {
        Optional<CategoriaDeChamado> pesquisa = categoriaDeChamadoRepository.findById(id);
        if (pesquisa.isPresent()) {
            var entidade = CategoriaDeChamadoEntradaDTO.paraEntidade(dto, id);
            categoriaDeChamadoRepository.save(entidade);
            return CategoriaDeChamadoDetalheSaidaDTO.paraDto(entidade);
        }
        return null;
    }

    public Optional<CategoriaDeChamadoDetalheSaidaDTO> deletar(Long id) {
        Optional<CategoriaDeChamado> pesquisa = categoriaDeChamadoRepository.findById(id);
        if (pesquisa.isPresent()) {
            var entidade = pesquisa.get();
            categoriaDeChamadoRepository.deleteById(id);
            var dto = CategoriaDeChamadoDetalheSaidaDTO.paraDto(entidade);
            return Optional.of(dto);
        }
        return Optional.empty();
    }
}
