package br.org.olabi.razenflix.repository;

import br.org.olabi.razenflix.model.value.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SerieRepository extends JpaRepository<Serie, UUID> {
    // DEFINIR OS MÉTODOS QUE VÃO GERAR AS QUERIES
}
