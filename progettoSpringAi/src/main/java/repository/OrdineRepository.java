package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Ordine;

public interface OrdineRepository extends JpaRepository<Ordine, Long> {
	boolean existsByProdotto_Id(Long prodottoId);
}
