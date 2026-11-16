package ex.gestioneconcessionari.command;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ex.gestioneconcessionari.dto.ConcessionarioRequestDTO;
import ex.gestioneconcessionari.dto.ConcessionarioResponseDTO;
import ex.gestioneconcessionari.service.ConcessionarioService;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class UpdateConcessionarioCommand {

    private final ConcessionarioService concessionarioService;

    private Long id;
    private ConcessionarioRequestDTO richiesta;

    public UpdateConcessionarioCommand(
            ConcessionarioService concessionarioService) {
        this.concessionarioService = concessionarioService;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRichiesta(ConcessionarioRequestDTO richiesta) {
        this.richiesta = richiesta;
    }

    public ConcessionarioResponseDTO execute() {
        return concessionarioService.modifica(id, richiesta);
    }
}