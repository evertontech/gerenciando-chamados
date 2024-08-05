package io.github.evertontech.gerenciando_chamados.model.repository;

import io.github.evertontech.gerenciando_chamados.model.entity.Chamado;
import org.springframework.data.repository.CrudRepository;

public interface ChamadoRepository extends CrudRepository<Chamado, Long> {
}
