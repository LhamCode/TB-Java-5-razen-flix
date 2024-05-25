package br.org.olabi.razenflix.repository;

import br.org.olabi.razenflix.model.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FilmeRepository extends JpaRepository<Filme, UUID> {
    // DEFINIR OS MÉTODOS QUE VÃO GERAR AS QUERIES
}
