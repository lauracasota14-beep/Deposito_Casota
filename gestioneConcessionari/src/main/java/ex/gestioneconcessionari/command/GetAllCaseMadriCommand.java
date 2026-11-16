package ex.gestioneconcessionari.command;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ex.gestioneconcessionari.dto.CasaMadreResponseDTO;
import ex.gestioneconcessionari.service.CasaMadreService;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GetAllCaseMadriCommand {

    private final CasaMadreService casaMadreService;

    public GetAllCaseMadriCommand(CasaMadreService casaMadreService) {
        this.casaMadreService = casaMadreService;
    }

    public List<CasaMadreResponseDTO> execute() {
        return casaMadreService.trovaTutte();
    }
}