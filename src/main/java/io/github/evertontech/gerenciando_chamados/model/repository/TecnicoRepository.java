package io.github.evertontech.gerenciando_chamados.model.repository;

import io.github.evertontech.gerenciando_chamados.model.entity.Tecnico;
import org.springframework.data.repository.CrudRepository;

public interface TecnicoRepository extends CrudRepository<Tecnico, Long> {
}
