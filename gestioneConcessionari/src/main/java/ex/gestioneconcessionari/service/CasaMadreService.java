package ex.gestioneconcessionari.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import ex.gestioneconcessionari.dto.CasaMadreRequestDTO;
import ex.gestioneconcessionari.dto.CasaMadreResponseDTO;
import ex.gestioneconcessionari.entity.CasaMadre;
import ex.gestioneconcessionari.entity.Concessionario;
import ex.gestioneconcessionari.repository.CasaMadreRepository;

@Service
@Transactional(readOnly = true)//fa eseguire il metodo dentro una transazione del database
public class CasaMadreService {

    private final CasaMadreRepository casaMadreRepository;

    public CasaMadreService(CasaMadreRepository casaMadreRepository) {
        this.casaMadreRepository = casaMadreRepository;
    }

    public List<CasaMadreResponseDTO> trovaTutte() {

        List<CasaMadre> caseMadri = casaMadreRepository.findAll();
        List<CasaMadreResponseDTO> risposta = new ArrayList<>();

        for (CasaMadre casaMadre : caseMadri) {
            risposta.add(convertiInDTO(casaMadre));
        }

        return risposta;
    }
    
    public CasaMadreResponseDTO trovaPerId(Long id) {

        CasaMadre casaMadre = casaMadreRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Casa madre non trovata con ID: " + id
                ));

        return convertiInDTO(casaMadre);
    }

    //inserisce
    @Transactional
    public CasaMadreResponseDTO inserisci(CasaMadreRequestDTO richiesta) {

        if (richiesta.getRagioneSociale() == null
                || richiesta.getRagioneSociale().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "La ragione sociale è obbligatoria"
            );
        }

        if (richiesta.getSedeLegale() == null
                || richiesta.getSedeLegale().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "La sede legale è obbligatoria"
            );
        }

        if (richiesta.getPaese() == null
                || richiesta.getPaese().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Il paese è obbligatorio"
            );
        }

        CasaMadre casaMadre = new CasaMadre();

        casaMadre.setRagioneSociale(richiesta.getRagioneSociale());
        casaMadre.setSedeLegale(richiesta.getSedeLegale());
        casaMadre.setPaese(richiesta.getPaese());
        casaMadre.setAnnoFondazione(richiesta.getAnnoFondazione());
        casaMadre.setFatturatoAnnuo(richiesta.getFatturatoAnnuo());

        CasaMadre salvata = casaMadreRepository.save(casaMadre);

        return convertiInDTO(salvata);
    }

    //modifica 
    @Transactional
    public CasaMadreResponseDTO modifica(
            Long id, CasaMadreRequestDTO richiesta) {

        CasaMadre casaMadre = casaMadreRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Casa madre non trovata con ID: " + id
                ));

        if (richiesta.getRagioneSociale() == null
                || richiesta.getRagioneSociale().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "La ragione sociale è obbligatoria!!!!"
            );
        }

        if (richiesta.getSedeLegale() == null
                || richiesta.getSedeLegale().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "La sede legale è obbligatoria!!!!"
            );
        }

        if (richiesta.getPaese() == null
                || richiesta.getPaese().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Il paese è obbligatorio!"
            );
        }

        casaMadre.setRagioneSociale(richiesta.getRagioneSociale());
        casaMadre.setSedeLegale(richiesta.getSedeLegale());
        casaMadre.setPaese(richiesta.getPaese());
        casaMadre.setAnnoFondazione(richiesta.getAnnoFondazione());
        casaMadre.setFatturatoAnnuo(richiesta.getFatturatoAnnuo());

        CasaMadre salvata = casaMadreRepository.save(casaMadre);

        return convertiInDTO(salvata);
    }
    
    //elimina
    @Transactional
    public String elimina(Long id) {

        if (!casaMadreRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Casa madre non trovata con ID: " + id
            );
        }

        CasaMadre casaMadre = casaMadreRepository.findById(id).get();

        //isempty controlla se la lista è vuota
        if (!casaMadre.getConcessionari().isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Impossibile eliminare: ci sono concessionari associati"
            );
        }

        casaMadreRepository.delete(casaMadre);

        return "Casa madre con ID " + id + " eliminata con successo";
    }

    private CasaMadreResponseDTO convertiInDTO(CasaMadre casaMadre) {

        CasaMadreResponseDTO dto = new CasaMadreResponseDTO();

        dto.setId(casaMadre.getId());
        dto.setRagioneSociale(casaMadre.getRagioneSociale());
        dto.setPaese(casaMadre.getPaese());
        dto.setFatturatoAnnuo(casaMadre.getFatturatoAnnuo());
        dto.setNumeroConcessionari(casaMadre.getConcessionari().size());

        BigDecimal totale = BigDecimal.ZERO;

        for (Concessionario concessionario : casaMadre.getConcessionari()) {
            if (concessionario.getFatturato() != null) {
                totale = totale.add(concessionario.getFatturato());
            }
        }

        dto.setFatturatoTotaleConcessionari(totale);

        return dto;
    }
}