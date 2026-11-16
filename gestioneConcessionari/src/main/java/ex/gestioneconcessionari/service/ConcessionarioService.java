package ex.gestioneconcessionari.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import ex.gestioneconcessionari.dto.ConcessionarioRequestDTO;
import ex.gestioneconcessionari.dto.ConcessionarioResponseDTO;
import ex.gestioneconcessionari.entity.CasaMadre;
import ex.gestioneconcessionari.entity.Concessionario;
import ex.gestioneconcessionari.repository.CasaMadreRepository;
import ex.gestioneconcessionari.repository.ConcessionarioRepository;

@Service
@Transactional(readOnly = true)
public class ConcessionarioService {

    private final ConcessionarioRepository concessionarioRepository;
    private final CasaMadreRepository casaMadreRepository;

    public ConcessionarioService(
            ConcessionarioRepository concessionarioRepository,
            CasaMadreRepository casaMadreRepository) {

        this.concessionarioRepository = concessionarioRepository;
        this.casaMadreRepository = casaMadreRepository;
    }

    //get
    public List<ConcessionarioResponseDTO> trovaTutti() {

        List<Concessionario> concessionari =
                concessionarioRepository.findAll();

        List<ConcessionarioResponseDTO> risposta = new ArrayList<>();

        for (Concessionario concessionario : concessionari) {
            risposta.add(convertiInDTO(concessionario));
        }

        return risposta;
    }

    public ConcessionarioResponseDTO trovaPerId(Long id) {

        Concessionario concessionario = concessionarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Concessionario non trovato con ID: " + id
                ));

        return convertiInDTO(concessionario);
    }

    //aggiungere
    @Transactional
    public ConcessionarioResponseDTO inserisci(
            ConcessionarioRequestDTO richiesta) {

        controllaDati(richiesta);

        CasaMadre casaMadre = casaMadreRepository
                .findById(richiesta.getCasaMadreId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Casa madre non trovata con ID: "
                                + richiesta.getCasaMadreId()
                ));

        Concessionario concessionario = new Concessionario();

        concessionario.setNome(richiesta.getNome());
        concessionario.setCitta(richiesta.getCitta());
        concessionario.setIndirizzo(richiesta.getIndirizzo());
        concessionario.setTelefono(richiesta.getTelefono());
        concessionario.setFatturato(richiesta.getFatturato());
        concessionario.setCasaMadre(casaMadre);

        Concessionario salvato =
                concessionarioRepository.save(concessionario);

        return convertiInDTO(salvato);
    }

    //modifica
    @Transactional
    public ConcessionarioResponseDTO modifica(
            Long id, ConcessionarioRequestDTO richiesta) {

        Concessionario concessionario = concessionarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Concessionario non trovato con ID: " + id
                ));

        controllaDati(richiesta);

        CasaMadre casaMadre = casaMadreRepository
                .findById(richiesta.getCasaMadreId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Casa madre non trovata con ID: "
                                + richiesta.getCasaMadreId()
                ));

        concessionario.setNome(richiesta.getNome());
        concessionario.setCitta(richiesta.getCitta());
        concessionario.setIndirizzo(richiesta.getIndirizzo());
        concessionario.setTelefono(richiesta.getTelefono());
        concessionario.setFatturato(richiesta.getFatturato());
        concessionario.setCasaMadre(casaMadre);

        Concessionario salvato =
                concessionarioRepository.save(concessionario);

        return convertiInDTO(salvato);
    }

    //elimina
    @Transactional
    public String elimina(Long id) {

        Concessionario concessionario = concessionarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Concessionario non trovato con ID: " + id
                ));

        if (!concessionario.getClienti().isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Impossibile eliminare: ci sono clienti associati"
            );
        }

        concessionarioRepository.delete(concessionario);

        return "Concessionario con ID " + id + " eliminato con successo";
    }

    // Controlli comuni a inserimento e modifica
    private void controllaDati(ConcessionarioRequestDTO richiesta) {

        if (richiesta.getNome() == null
                || richiesta.getNome().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Il nome è obbligatorio"
            );
        }

        if (richiesta.getCitta() == null
                || richiesta.getCitta().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "La città è obbligatoria"
            );
        }

        if (richiesta.getCasaMadreId() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "L'ID della casa madre è obbligatorio"
            );
        }
    }

    private ConcessionarioResponseDTO convertiInDTO(
            Concessionario concessionario) {

        ConcessionarioResponseDTO dto =
                new ConcessionarioResponseDTO();

        dto.setId(concessionario.getId());
        dto.setNome(concessionario.getNome());
        dto.setCitta(concessionario.getCitta());
        dto.setFatturato(concessionario.getFatturato());
        dto.setCasaMadreNome(
                concessionario.getCasaMadre().getRagioneSociale()
        );
        dto.setNumeroClienti(concessionario.getClienti().size());

        return dto;
    }
}