package ingles.traducciones.controllers;

import ingles.traducciones.entity.Grupo;
import ingles.traducciones.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grupo")
public class GrupoController extends AbstractController<Grupo> {

    @Autowired
    protected GrupoController(GrupoService service) {
        super(service);
    }
}
