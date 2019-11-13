package ingles.traducciones.service;


import ingles.traducciones.entity.Grupo;
import ingles.traducciones.respository.GrupoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrupoService extends AbstractService<Grupo>{

    @Autowired
    protected GrupoService(GrupoRespository repository) {
        super(repository);
    }

}
