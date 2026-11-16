package service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import dto.OrdineDto;
import dto.OrdineRequest;
import model.Ordine;
import model.Prodotto;
import model.Utente;
import repository.OrdineRepository;
import repository.ProdottoRepository;
import repository.UtenteRepository;

@Service
public class OrdineService {

    private final OrdineRepository ordineRepository;
    private final UtenteRepository utenteRepository;
    private final ProdottoRepository prodottoRepository;

    public OrdineService(
            OrdineRepository ordineRepository,
            UtenteRepository utenteRepository,
            ProdottoRepository prodottoRepository) {

        this.ordineRepository = ordineRepository;
        this.utenteRepository = utenteRepository;
        this.prodottoRepository = prodottoRepository;
    }

    public OrdineDto creaOrdine(OrdineRequest richiesta)
            throws ExceptionCustom {

        if (richiesta.utenteId() == null
                || richiesta.prodottoId() == null
                || richiesta.quantita() == null
                || richiesta.quantita() <= 0) {

            throw new ExceptionCustom(
                    "Dati mancanti o quantità non valida");
        }

        Utente utente = utenteRepository
                .findById(richiesta.utenteId())
                .orElse(null);

        Prodotto prodotto = prodottoRepository
                .findById(richiesta.prodottoId())
                .orElse(null);

        if (utente == null || prodotto == null) {
            throw new ExceptionCustom(
                    "Utente o prodotto non trovato");
        }

        if (!prodotto.isDisponibile()) {
            throw new ExceptionCustom("Prodotto non disponibile");
        }

        if (prodotto.getPrezzo() == null) {
            throw new ExceptionCustom("Prezzo mancante");
        }

        if (prodotto.getPrezzo().compareTo(BigDecimal.ZERO) < 0) {
            throw new ExceptionCustom("Prezzo negativo");
        }

        if (ordineRepository.existsByProdotto_Id(prodotto.getId())) {
            throw new ExceptionCustom(
                    "Prodotto già associato a un ordine");
        }

        Ordine ordine = new Ordine();

        ordine.setUtente(utente);
        ordine.setProdotto(prodotto);
        ordine.setQuantita(richiesta.quantita());

        ordine.setPrezzoTotale(
                prodotto.getPrezzo().multiply(
                        BigDecimal.valueOf(richiesta.quantita()))
        );

        ordine.setDataOrdine(LocalDateTime.now());
        ordine.setStato("CREATO");

        Ordine salvato = ordineRepository.save(ordine);

        return toDto(salvato);
    }

    public List<OrdineDto> getTuttiOrdini() {
        return ordineRepository.findAll()
                .stream()
                .map(ordine -> toDto(ordine))
                .toList();
    }

    private OrdineDto toDto(Ordine ordine) {
        return new OrdineDto(
                ordine.getId(),
                ordine.getUtente().getId(),
                ordine.getProdotto().getId(),
                ordine.getQuantita(),
                ordine.getPrezzoTotale(),
                ordine.getDataOrdine(),
                ordine.getStato()
        );
    }
}