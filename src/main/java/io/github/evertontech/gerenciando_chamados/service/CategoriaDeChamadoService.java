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
    CategoriaDeChamadoRepository categoriaChamadoRepository;


    public CategoriaDeChamado criar(CategoriaDeChamadoEntradaDTO dto) {
        CategoriaDeChamado entidade = new CategoriaDeChamado();
        entidade.setNome(dto.getNome());
        entidade.setDescricao(dto.getDescricao());
        return categoriaChamadoRepository.save(entidade);
    }

    public Iterable<CategoriaDeChamadoResumoSaidaDTO> listar() {
        var categorias = categoriaChamadoRepository.findAll();
        var stream = StreamSupport.stream(categorias.spliterator(), true);
        return stream.map(CategoriaDeChamadoResumoSaidaDTO::paraDto).toList();
    }

    public Optional<CategoriaDeChamadoDetalheSaidaDTO> obterPorId(Long id) {

        Optional<CategoriaDeChamado> pesquisa = categoriaChamadoRepository.findById(id);
        if (pesquisa.isPresent()) {
            var entidade = pesquisa.get();
            var dto = CategoriaDeChamadoDetalheSaidaDTO.paraDto(entidade);
            return Optional.of(dto);
        }

        return Optional.empty();
    }

    public CategoriaDeChamado atualizar(CategoriaDeChamadoEntradaDTO dto, Long id) {
        CategoriaDeChamado entidade = new CategoriaDeChamado();
        entidade.setId(id);
        entidade.setNome(dto.getNome());
        entidade.setDescricao(dto.getDescricao());
        return categoriaChamadoRepository.save(entidade);
    }

    public void deletar(Long id) {
        categoriaChamadoRepository.deleteById(id);
    }
}
