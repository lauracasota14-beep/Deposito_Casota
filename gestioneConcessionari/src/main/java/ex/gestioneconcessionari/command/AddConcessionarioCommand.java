package ex.gestioneconcessionari.command;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ex.gestioneconcessionari.dto.ConcessionarioRequestDTO;
import ex.gestioneconcessionari.dto.ConcessionarioResponseDTO;
import ex.gestioneconcessionari.service.ConcessionarioService;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class AddConcessionarioCommand {

    private final ConcessionarioService concessionarioService;
    private ConcessionarioRequestDTO richiesta;

    public AddConcessionarioCommand(
            ConcessionarioService concessionarioService) {
        this.concessionarioService = concessionarioService;
    }

    public void setRichiesta(ConcessionarioRequestDTO richiesta) {
        this.richiesta = richiesta;
    }

    public ConcessionarioResponseDTO execute() {
        return concessionarioService.inserisci(richiesta);
    }
}