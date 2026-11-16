package ex.gestioneconcessionari.command;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ex.gestioneconcessionari.dto.ConcessionarioResponseDTO;
import ex.gestioneconcessionari.service.ConcessionarioService;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GetAllConcessionariCommand {

    private final ConcessionarioService concessionarioService;

    public GetAllConcessionariCommand(
            ConcessionarioService concessionarioService) {
        this.concessionarioService = concessionarioService;
    }

    public List<ConcessionarioResponseDTO> execute() {
        return concessionarioService.trovaTutti();
    }
}