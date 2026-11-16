package dto;

import java.math.BigDecimal;

import model.Marca;

public record ProdottoDto(Long id, String nome, String descrizione, BigDecimal prezzo, boolean disponibile, Marca marca) {

}
