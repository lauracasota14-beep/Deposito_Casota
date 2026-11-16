package service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dto.ProdottoDto;
import model.Prodotto;
import repository.ProdottoRepository;

@Service
public class ProdottoService implements ProdottoServiceInterface{
	private final ProdottoRepository prodottoRepository;
	
	public ProdottoService(ProdottoRepository prodottoRepository) {
		this.prodottoRepository = prodottoRepository;
	}
	
	public ProdottoDto creaProdotto(ProdottoDto richiesta) {

	    Prodotto prodotto = new Prodotto();

	    prodotto.setNome(richiesta.nome());
	    prodotto.setDescrizione(richiesta.descrizione());
	    prodotto.setPrezzo(richiesta.prezzo());
	    prodotto.setDisponibile(richiesta.disponibile());

	    prodotto = prodottoRepository.save(prodotto);

	    return toDto(prodotto);
	}

	public List<ProdottoDto> getTuttiProdotti() {

	    return prodottoRepository.findAll()
	            .stream()
	            .map(prodotto -> toDto(prodotto))
	            .toList();
	}

	public ProdottoDto getProdottoById(Long id) {

	    Prodotto prodotto = prodottoRepository.findById(id).orElse(null);

	    if (prodotto == null) {
	        throw new ResponseStatusException(
	                HttpStatus.NOT_FOUND, "Prodotto non trovato");
	    }

	    return toDto(prodotto);
	}

	private ProdottoDto toDto(Prodotto prodotto) {

	    return new ProdottoDto(
	            prodotto.getId(),
	            prodotto.getNome(),
	            prodotto.getDescrizione(),
	            prodotto.getPrezzo(),
	            prodotto.isDisponibile(),
	            prodotto.getMarca()
	    );
	}
}
