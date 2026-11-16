package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Prodotto;

public interface ProdottoRepository extends JpaRepository<Prodotto, Long>{

}
