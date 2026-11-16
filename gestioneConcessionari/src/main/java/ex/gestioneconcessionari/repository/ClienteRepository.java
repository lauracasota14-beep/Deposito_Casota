package ex.gestioneconcessionari.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ex.gestioneconcessionari.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    boolean existsByEmail(String email);

    boolean existsByEmailAndIdNot(String email, Long id);
}