package service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dto.UtenteDto;
import model.Utente;
import repository.UtenteRepository;

@Service
public class UtenteService {

    private final UtenteRepository utenteRepository;

    public UtenteService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public UtenteDto creaUtente(UtenteDto richiesta) {
        Utente utente = new Utente();

        utente.setNome(richiesta.nome());
        utente.setCognome(richiesta.cognome());
        utente.setEmail(richiesta.email());

        Utente salvato = utenteRepository.save(utente);

        return toDto(salvato);
    }

    public List<UtenteDto> getTuttiUtenti() {
        return utenteRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public UtenteDto getUtenteById(Long id) {
        Utente utente = utenteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Utente non trovato"
                ));

        return toDto(utente);
    }

    private UtenteDto toDto(Utente utente) {
        return new UtenteDto(
                utente.getId(),
                utente.getNome(),
                utente.getCognome(),
                utente.getEmail()
        );
    }
}