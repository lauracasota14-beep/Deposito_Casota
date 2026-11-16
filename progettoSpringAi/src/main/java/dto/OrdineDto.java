package dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrdineDto(Long id, Long utenteId, Long prodottoId, Integer quantita, BigDecimal prezzoTotale, LocalDateTime dataOrdine, String stato) {

}
