package io.github.evertontech.gerenciando_chamados.service;

import io.github.evertontech.gerenciando_chamados.dto.entrada.CategoriaChamadoEntradaDTO;
import io.github.evertontech.gerenciando_chamados.dto.saida.CategoriaChamadoSaidaDTO;
import io.github.evertontech.gerenciando_chamados.dto.saida.CategoriaChamadoSaidaListaDTO;
import io.github.evertontech.gerenciando_chamados.model.entity.CategoriaChamado;
import io.github.evertontech.gerenciando_chamados.model.repository.CategoriaChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class CategoriaChamadoService {

    @Autowired
    CategoriaChamadoRepository categoriaChamadoRepository;


    public CategoriaChamado criar(CategoriaChamadoEntradaDTO dto) {
        CategoriaChamado entidade = new CategoriaChamado();
        entidade.setNome(dto.getNome());
        entidade.setDescricao(dto.getDescricao());
        return categoriaChamadoRepository.save(entidade);
    }

    public Iterable<CategoriaChamadoSaidaListaDTO> listar() {
        var categorias = categoriaChamadoRepository.findAll();
        var stream = StreamSupport.stream(categorias.spliterator(), true);
        return stream.map(CategoriaChamadoSaidaListaDTO::paraDto).toList();
    }

    public Optional<CategoriaChamadoSaidaDTO> obterPorId(Long id) {

        Optional<CategoriaChamado> pesquisa = categoriaChamadoRepository.findById(id);
        if (pesquisa.isPresent()) {
            var entidade = pesquisa.get();
            var dto = CategoriaChamadoSaidaDTO.paraDto(entidade);
            return Optional.of(dto);
        }

        return Optional.empty();
    }

    public CategoriaChamado atualizar(CategoriaChamadoEntradaDTO dto, Long id) {
        CategoriaChamado entidade = new CategoriaChamado();
        entidade.setId(id);
        entidade.setNome(dto.getNome());
        entidade.setDescricao(dto.getDescricao());
        return categoriaChamadoRepository.save(entidade);
    }

    public void deletar(Long id) {
        categoriaChamadoRepository.deleteById(id);
    }
}
