package ex.gestioneconcessionari.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ex.gestioneconcessionari.entity.CasaMadre;

public interface CasaMadreRepository
        extends JpaRepository<CasaMadre, Long> {
}