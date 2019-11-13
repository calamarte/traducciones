package ingles.traducciones.controllers;

import ingles.traducciones.entity.Grupo;
import ingles.traducciones.entity.Palabra;
import ingles.traducciones.service.PalabraService;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/palabra")
public class PalabraController extends AbstractController<Palabra>{

    private Logger logger = LoggerFactory.getLogger(PalabraController.class);

    @Autowired
    protected PalabraController(PalabraService service) {
        super(service);
    }

    @GetMapping(value = "/grupo/{nombreGrupo}")
    public List<Palabra> findByGrupo(String nombreGrupo){
        return ((PalabraService) service).findByGrupo(nombreGrupo);
    }

    @GetMapping(value = "/grupo/all")
    public List<Grupo> findAllGroupByGrupo(){
        return ((PalabraService)service).groupByGrupo();
    }

    @PostMapping(value = "/save/grupo")
    public String saveByGrupo(@RequestBody Map<String, List<Palabra>> info){

        for (String key : info.keySet()){
            if(!Strings.isBlank(key)) {
                ((PalabraService) service).saveAll(key, info.get(key));
            }

            logger.warn("El nombre del grupo no es correcto");
        }

        return "OK";
    }
}
