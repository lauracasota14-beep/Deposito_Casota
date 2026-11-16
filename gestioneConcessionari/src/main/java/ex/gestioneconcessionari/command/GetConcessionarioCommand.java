package ex.gestioneconcessionari.command;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ex.gestioneconcessionari.dto.ConcessionarioResponseDTO;
import ex.gestioneconcessionari.service.ConcessionarioService;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GetConcessionarioCommand {

    private final ConcessionarioService concessionarioService;
    private Long id;

    public GetConcessionarioCommand(
            ConcessionarioService concessionarioService) {
        this.concessionarioService = concessionarioService;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ConcessionarioResponseDTO execute() {
        return concessionarioService.trovaPerId(id);
    }
}