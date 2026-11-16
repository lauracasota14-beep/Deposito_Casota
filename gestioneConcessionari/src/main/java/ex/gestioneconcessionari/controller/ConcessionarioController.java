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

import ex.gestioneconcessionari.command.AddConcessionarioCommand;
import ex.gestioneconcessionari.command.DeleteConcessionarioCommand;
import ex.gestioneconcessionari.command.GetAllConcessionariCommand;
import ex.gestioneconcessionari.command.GetConcessionarioCommand;
import ex.gestioneconcessionari.command.UpdateConcessionarioCommand;
import ex.gestioneconcessionari.dto.ConcessionarioRequestDTO;
import ex.gestioneconcessionari.dto.ConcessionarioResponseDTO;

@RestController
@RequestMapping("/api/concessionari")
public class ConcessionarioController {

    private final BeanFactory beanFactory;

    public ConcessionarioController(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @GetMapping
    public ResponseEntity<List<ConcessionarioResponseDTO>> trovaTutti() {

        GetAllConcessionariCommand command = beanFactory.getBean(GetAllConcessionariCommand.class);
        return ResponseEntity.ok(command.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConcessionarioResponseDTO> trovaPerId(@PathVariable("id") Long id) {

        GetConcessionarioCommand command = beanFactory.getBean(GetConcessionarioCommand.class);
        command.setId(id);

        return ResponseEntity.ok(command.execute());
    }

    @PostMapping
    public ResponseEntity<ConcessionarioResponseDTO> inserisci(@RequestBody ConcessionarioRequestDTO richiesta) {

        AddConcessionarioCommand command = beanFactory.getBean(AddConcessionarioCommand.class);
        command.setRichiesta(richiesta);

        return ResponseEntity.status(HttpStatus.CREATED).body(command.execute());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConcessionarioResponseDTO> modifica(@PathVariable("id") Long id,@RequestBody ConcessionarioRequestDTO richiesta) {

        UpdateConcessionarioCommand command = beanFactory.getBean(UpdateConcessionarioCommand.class);
        command.setId(id);
        command.setRichiesta(richiesta);
        return ResponseEntity.ok(command.execute());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> elimina(@PathVariable("id") Long id) {

        DeleteConcessionarioCommand command = beanFactory.getBean(DeleteConcessionarioCommand.class);
        command.setId(id);
        return ResponseEntity.ok(command.execute());
    }
}