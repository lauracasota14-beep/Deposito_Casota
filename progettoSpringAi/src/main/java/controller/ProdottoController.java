package controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.ProdottoDto;
import service.ProdottoServiceInterface;

@RestController
@RequestMapping("/prodotti")
public class ProdottoController {

    private final ProdottoServiceInterface prodottoService;

    public ProdottoController(ProdottoServiceInterface prodottoService) {
        this.prodottoService = prodottoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProdottoDto>> getTuttiProdotti() {
        return ResponseEntity.ok(prodottoService.getTuttiProdotti());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdottoDto> getProdottoById(
            @PathVariable("id") Long id) {

        return ResponseEntity.ok(prodottoService.getProdottoById(id));
    }

    @PostMapping("/new")
    public ResponseEntity<ProdottoDto> creaProdotto(
            @RequestBody ProdottoDto richiesta) {

        return ResponseEntity.ok(prodottoService.creaProdotto(richiesta));
    }
}