package ex.gestioneconcessionari.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ex.gestioneconcessionari.entity.Concessionario;

public interface ConcessionarioRepository
        extends JpaRepository<Concessionario, Long> {
}