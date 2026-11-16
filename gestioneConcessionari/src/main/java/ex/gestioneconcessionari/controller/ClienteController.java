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

import ex.gestioneconcessionari.command.AddClienteCommand;
import ex.gestioneconcessionari.command.DeleteClienteCommand;
import ex.gestioneconcessionari.command.GetAllClientiCommand;
import ex.gestioneconcessionari.command.GetClienteCommand;
import ex.gestioneconcessionari.command.UpdateClienteCommand;
import ex.gestioneconcessionari.dto.ClienteRequestDTO;
import ex.gestioneconcessionari.dto.ClienteResponseDTO;

@RestController
@RequestMapping("/api/clienti")
public class ClienteController {

    private final BeanFactory beanFactory;

    public ClienteController(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> trovaTutti() {

        GetAllClientiCommand command = beanFactory.getBean(GetAllClientiCommand.class);

        return ResponseEntity.ok(command.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> trovaPerId(@PathVariable("id") Long id) {

        GetClienteCommand command = beanFactory.getBean(GetClienteCommand.class);
        command.setId(id);
        return ResponseEntity.ok(command.execute());
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> inserisci(@RequestBody ClienteRequestDTO richiesta) {

        AddClienteCommand command = beanFactory.getBean(AddClienteCommand.class);

        command.setRichiesta(richiesta);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(command.execute());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> modifica(@PathVariable("id") Long id,
            @RequestBody ClienteRequestDTO richiesta) {

        UpdateClienteCommand command = beanFactory.getBean(UpdateClienteCommand.class);
        command.setId(id);
        command.setRichiesta(richiesta);

        return ResponseEntity.ok(command.execute());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> elimina(@PathVariable("id") Long id) {

        DeleteClienteCommand command = beanFactory.getBean(DeleteClienteCommand.class);
        command.setId(id);
        return ResponseEntity.ok(command.execute());
    }
}