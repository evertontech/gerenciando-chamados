package io.github.evertontech.gerenciando_chamados.service;

import io.github.evertontech.gerenciando_chamados.dto.entrada.TecnicoEntradaDTO;
import io.github.evertontech.gerenciando_chamados.dto.saida.detalhe.TecnicoDetalheSaidaDTO;
import io.github.evertontech.gerenciando_chamados.dto.saida.resumo.TecnicoResumoSaidaDTO;
import io.github.evertontech.gerenciando_chamados.model.entity.Tecnico;
import io.github.evertontech.gerenciando_chamados.model.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class TecnicoService {

    @Autowired
    TecnicoRepository tecnicoRepository;

    public TecnicoDetalheSaidaDTO criar(TecnicoEntradaDTO dto) {
        var entidade = TecnicoEntradaDTO.paraEntidade(dto);
        tecnicoRepository.save(entidade);
        return TecnicoDetalheSaidaDTO.paraDTO(entidade);
    }

    public Iterable<TecnicoResumoSaidaDTO> listar() {
        var tecnicosdtoSaida = tecnicoRepository.findAll();
        var stream = StreamSupport.stream(tecnicosdtoSaida.spliterator(), true);
        return stream.map(TecnicoResumoSaidaDTO::paraDto).toList();
    }

    public Optional<TecnicoDetalheSaidaDTO> obterPorId(Long id) {
        Optional<Tecnico> pesquisa = tecnicoRepository.findById(id);
        if (pesquisa.isPresent()) {
            var entidade = pesquisa.get();
            var dto = TecnicoDetalheSaidaDTO.paraDTO(entidade);
            return Optional.of(dto);
        }
        return Optional.empty();
    }

    public TecnicoDetalheSaidaDTO atualizar(TecnicoEntradaDTO tecnico, Long id) {
        Optional<Tecnico> pesquisa = tecnicoRepository.findById(id);
        if (pesquisa.isPresent()) {
            var entidade = TecnicoEntradaDTO.paraEntidade(tecnico, id);
            tecnicoRepository.save(entidade);
            return TecnicoDetalheSaidaDTO.paraDTO(entidade);
        }
        return null;
    }

    public Optional<TecnicoDetalheSaidaDTO> deletar(Long id) {
        var pesquisa = tecnicoRepository.findById(id);
        if (pesquisa.isPresent()) {
            tecnicoRepository.deleteById(id);
            var entidade = pesquisa.get();
            var dto = TecnicoDetalheSaidaDTO.paraDTO(entidade);
            return Optional.of(dto);
        }
        return Optional.empty();
    }
}
