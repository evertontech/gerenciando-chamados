package io.github.evertontech.gerenciando_chamados.service;

import io.github.evertontech.gerenciando_chamados.dto.entrada.ChamadoEntradaDTO;
import io.github.evertontech.gerenciando_chamados.dto.saida.detalhe.ChamadoDetalheSaidaDTO;
import io.github.evertontech.gerenciando_chamados.dto.saida.resumo.ChamadoResumoSaidaDTO;
import io.github.evertontech.gerenciando_chamados.model.entity.Chamado;
import io.github.evertontech.gerenciando_chamados.model.repository.CategoriaDeChamadoRepository;
import io.github.evertontech.gerenciando_chamados.model.repository.ChamadoRepository;
import io.github.evertontech.gerenciando_chamados.model.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ChamadoService {

    @Autowired
    ChamadoRepository chamadoRepository;

    @Autowired
    TecnicoRepository tecnicoRepository;

    @Autowired
    CategoriaDeChamadoRepository categoriaDeChamadoRepository;

    public ChamadoDetalheSaidaDTO criar(ChamadoEntradaDTO dto) {
        var tecnicoProcurado = tecnicoRepository.findById(dto.getTecnicoId());
        var categoriaDeChamadoProcurada = categoriaDeChamadoRepository.findById(dto.getCategoriaDeChamadoId());
        if (tecnicoProcurado.isPresent() && categoriaDeChamadoProcurada.isPresent()) {
            var tecnico = tecnicoProcurado.get();
            var categoriaDeChamado = categoriaDeChamadoProcurada.get();
            var entidade = ChamadoEntradaDTO.paraEntidade(dto, tecnico, categoriaDeChamado);
            chamadoRepository.save(entidade);
            return ChamadoDetalheSaidaDTO.paraDto(entidade);
        }
        return null;
    }

    public Optional<ChamadoDetalheSaidaDTO> obterPorId(Long id) {
        var pesquisa = chamadoRepository.findById(id);
        if (pesquisa.isPresent()) {
            var entidade = pesquisa.get();
            var dto = ChamadoDetalheSaidaDTO.paraDto(entidade);
            return Optional.of(dto);
        }
        return Optional.empty();
    }

    public Iterable<ChamadoResumoSaidaDTO> listarTodos() {
        var chamados = chamadoRepository.findAll();

        List<ChamadoResumoSaidaDTO> dtos = new ArrayList<>();

        for (Chamado chamado : chamados) {
            var dto = ChamadoResumoSaidaDTO.paraDto(chamado);
            dtos.add(dto);
        }

        return dtos;

    }

    public ChamadoDetalheSaidaDTO atualizar(ChamadoEntradaDTO dto, Long id) {
        var pesquisa = chamadoRepository.findById(id);
        if (pesquisa.isPresent()) {
            var tecnicoPesquisa = tecnicoRepository.findById(dto.getTecnicoId());
            var categoriaPesquisa = categoriaDeChamadoRepository.findById(dto.getCategoriaDeChamadoId());
            if (tecnicoPesquisa.isPresent() && categoriaPesquisa.isPresent()) {
                var tecnico = tecnicoPesquisa.get();
                var categoria = categoriaPesquisa.get();
                var entidade = ChamadoEntradaDTO.paraEntidade(dto, id, tecnico, categoria);
                chamadoRepository.save(entidade);
                return ChamadoDetalheSaidaDTO.paraDto(entidade);
            }
        }
        return null;
    }

    public Optional<ChamadoDetalheSaidaDTO> deletar(Long id) {
        var pesquisa = chamadoRepository.findById(id);
        if (pesquisa.isPresent()) {
            var entidade = pesquisa.get();
            chamadoRepository.deleteById(id);
            var dto = ChamadoDetalheSaidaDTO.paraDto(entidade);
            return Optional.of(dto);
        }
        return Optional.empty();
    }
}
