package ex.gestioneconcessionari.command;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ex.gestioneconcessionari.dto.ClienteRequestDTO;
import ex.gestioneconcessionari.dto.ClienteResponseDTO;
import ex.gestioneconcessionari.service.ClienteService;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class UpdateClienteCommand {

    private final ClienteService clienteService;

    private Long id;
    private ClienteRequestDTO richiesta;

    public UpdateClienteCommand(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRichiesta(ClienteRequestDTO richiesta) {
        this.richiesta = richiesta;
    }

    public ClienteResponseDTO execute() {
        return clienteService.modifica(id, richiesta);
    }
}