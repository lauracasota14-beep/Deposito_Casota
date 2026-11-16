package ex.gestioneconcessionari.controller;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ex.gestioneconcessionari.command.AddCasaMadreCommand;
import ex.gestioneconcessionari.command.DeleteCasaMadreCommand;
import ex.gestioneconcessionari.command.GetAllCaseMadriCommand;
import ex.gestioneconcessionari.command.GetCasaMadreCommand;
import ex.gestioneconcessionari.command.UpdateCasaMadreCommand;
import ex.gestioneconcessionari.dto.CasaMadreRequestDTO;
import ex.gestioneconcessionari.dto.CasaMadreResponseDTO;

@RestController
@RequestMapping("/api/case-madri")
public class CasaMadreController {

    private final BeanFactory beanFactory;

    public CasaMadreController(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @GetMapping
    public ResponseEntity<List<CasaMadreResponseDTO>> trovaTutte() {

        GetAllCaseMadriCommand command = beanFactory.getBean(GetAllCaseMadriCommand.class);
        return ResponseEntity.ok(command.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CasaMadreResponseDTO> trovaPerId(@PathVariable("id") Long id) {

        GetCasaMadreCommand command = beanFactory.getBean(GetCasaMadreCommand.class);
        command.setId(id);
        
        return ResponseEntity.ok(command.execute());
    }
    
    @PostMapping
    public ResponseEntity<CasaMadreResponseDTO> inserisci(@RequestBody CasaMadreRequestDTO richiesta) {
    	//RequestBody legge il JSON
        AddCasaMadreCommand command = beanFactory.getBean(AddCasaMadreCommand.class);
        command.setRichiesta(richiesta);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(command.execute());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CasaMadreResponseDTO> modifica(@PathVariable("id") Long id,
            @RequestBody CasaMadreRequestDTO richiesta) {

        UpdateCasaMadreCommand command = beanFactory.getBean(UpdateCasaMadreCommand.class);
        command.setId(id);
        command.setRichiesta(richiesta);

        return ResponseEntity.ok(command.execute());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> elimina(@PathVariable("id") Long id) {

        DeleteCasaMadreCommand command = beanFactory.getBean(DeleteCasaMadreCommand.class);
        command.setId(id);

        return ResponseEntity.ok(command.execute());
    }
}