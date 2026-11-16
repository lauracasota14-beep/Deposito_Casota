package service;

import java.util.List;

import dto.ProdottoDto;

public interface  ProdottoServiceInterface {
	
	ProdottoDto creaProdotto(ProdottoDto richiesta);
	
	List<ProdottoDto> getTuttiProdotti();
	
	ProdottoDto getProdottoById(Long id);
}
