package ex.gestioneconcessionari.command;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ex.gestioneconcessionari.service.ConcessionarioService;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class DeleteConcessionarioCommand {

    private final ConcessionarioService concessionarioService;
    private Long id;

    public DeleteConcessionarioCommand(
            ConcessionarioService concessionarioService) {
        this.concessionarioService = concessionarioService;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String execute() {
        return concessionarioService.elimina(id);
    }
}