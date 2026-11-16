package ex.gestioneconcessionari.command;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ex.gestioneconcessionari.service.CasaMadreService;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class DeleteCasaMadreCommand {

    private final CasaMadreService casaMadreService;
    private Long id;

    public DeleteCasaMadreCommand(CasaMadreService casaMadreService) {
        this.casaMadreService = casaMadreService;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String execute() {
        return casaMadreService.elimina(id);
    }
}