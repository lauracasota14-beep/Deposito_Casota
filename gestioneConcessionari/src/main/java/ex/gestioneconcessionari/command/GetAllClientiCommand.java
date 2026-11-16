package ex.gestioneconcessionari.command;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ex.gestioneconcessionari.dto.ClienteResponseDTO;
import ex.gestioneconcessionari.service.ClienteService;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GetAllClientiCommand {

    private final ClienteService clienteService;

    public GetAllClientiCommand(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public List<ClienteResponseDTO> execute() {
        return clienteService.trovaTutti();
    }
}