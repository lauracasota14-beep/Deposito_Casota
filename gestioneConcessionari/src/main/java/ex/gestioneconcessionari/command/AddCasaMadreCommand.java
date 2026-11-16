package ex.gestioneconcessionari.command;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ex.gestioneconcessionari.dto.CasaMadreRequestDTO;
import ex.gestioneconcessionari.dto.CasaMadreResponseDTO;
import ex.gestioneconcessionari.service.CasaMadreService;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class AddCasaMadreCommand {

    private final CasaMadreService casaMadreService;
    private CasaMadreRequestDTO richiesta;

    public AddCasaMadreCommand(CasaMadreService casaMadreService) {
        this.casaMadreService = casaMadreService;
    }

    public void setRichiesta(CasaMadreRequestDTO richiesta) {
        this.richiesta = richiesta;
    }

    public CasaMadreResponseDTO execute() {
        return casaMadreService.inserisci(richiesta);
    }
}