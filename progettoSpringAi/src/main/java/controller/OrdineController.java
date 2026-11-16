package controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.OrdineDto;
import dto.OrdineRequest;
import service.ExceptionCustom;
import service.OrdineService;

@RestController
@RequestMapping("/ordini")
public class OrdineController {

    private final OrdineService ordineService;

    public OrdineController(OrdineService ordineService) {
        this.ordineService = ordineService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> creaOrdine(
            @RequestBody OrdineRequest richiesta) {

        try {
            OrdineDto ordine = ordineService.creaOrdine(richiesta);
            return ResponseEntity.ok(ordine);

        } catch (ExceptionCustom e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        } finally {
            System.out.println(
                    "Richiesta di creazione ordine terminata");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrdineDto>> getTuttiOrdini() {
        return ResponseEntity.ok(ordineService.getTuttiOrdini());
    }
}