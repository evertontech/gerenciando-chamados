package io.github.evertontech.gerenciando_chamados.service;

import io.github.evertontech.gerenciando_chamados.dto.entrada.ChamadoEntradaDTO;
import io.github.evertontech.gerenciando_chamados.dto.saida.detalhe.ChamadoDetalheSaidaDTO;
import io.github.evertontech.gerenciando_chamados.dto.saida.resumo.ChamadoResumoSaidaDTO;
import io.github.evertontech.gerenciando_chamados.model.entity.Chamado;
import io.github.evertontech.gerenciando_chamados.model.repository.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChamadoService {

    @Autowired
    ChamadoRepository chamadoRepository;

    public ChamadoDetalheSaidaDTO criar(ChamadoEntradaDTO dto) {
        var entidade = ChamadoEntradaDTO.paraEntidade(dto);
        chamadoRepository.save(entidade);
        return ChamadoDetalheSaidaDTO.paraDto(entidade);
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

//    public Iterable<ChamadoResumoSaidaDTO> listarTodos(Long id) {
//        return chamadoRepository.findAll();
//    }


}
