package controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.UtenteDto;
import service.UtenteService;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

    private final UtenteService utenteService;

    public UtenteController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    @PostMapping
    public ResponseEntity<UtenteDto> creaUtente(
            @RequestBody UtenteDto richiesta) {

        UtenteDto utenteCreato = utenteService.creaUtente(richiesta);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(utenteCreato);
    }

    @GetMapping
    public List<UtenteDto> getTuttiUtenti() {
        return utenteService.getTuttiUtenti();
    }

    @GetMapping("/{id}")
    public UtenteDto getUtenteById(@PathVariable("id") Long id) {
        return utenteService.getUtenteById(id);
    }
}