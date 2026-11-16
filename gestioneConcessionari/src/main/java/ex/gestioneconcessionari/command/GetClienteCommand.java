package ex.gestioneconcessionari.command;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ex.gestioneconcessionari.dto.ClienteResponseDTO;
import ex.gestioneconcessionari.service.ClienteService;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GetClienteCommand {

    private final ClienteService clienteService;
    private Long id;

    public GetClienteCommand(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteResponseDTO execute() {
        return clienteService.trovaPerId(id);
    }
}