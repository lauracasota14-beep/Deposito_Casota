package ex.gestioneconcessionari.command;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ex.gestioneconcessionari.dto.ClienteRequestDTO;
import ex.gestioneconcessionari.dto.ClienteResponseDTO;
import ex.gestioneconcessionari.service.ClienteService;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class AddClienteCommand {

    private final ClienteService clienteService;
    private ClienteRequestDTO richiesta;

    public AddClienteCommand(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void setRichiesta(ClienteRequestDTO richiesta) {
        this.richiesta = richiesta;
    }

    public ClienteResponseDTO execute() {
        return clienteService.inserisci(richiesta);
    }
}