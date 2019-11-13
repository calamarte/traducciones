package ingles.traducciones.service;

import ingles.traducciones.entity.Grupo;
import ingles.traducciones.entity.Palabra;
import ingles.traducciones.respository.GrupoRespository;
import ingles.traducciones.respository.PalabraRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class PalabraService extends AbstractService{

    @Autowired
    private GrupoRespository grupoRespository;

    @Autowired
    private GrupoService grupoService;

    @Autowired
    protected PalabraService(PalabraRespository repository) {
        super(repository);
    }

    public List<Palabra> findByGrupo(String nombreGrupo){
        Set<Long> ids = grupoRespository.findByNombre(nombreGrupo).getPalabras_id();
        return (List<Palabra>) findById(ids);
    }

    public List<Grupo> groupByGrupo(){
        List<Grupo> grupos = grupoRespository.findAll();

                grupos.forEach(
                        g -> g.setPalabras((List)repository.findAllById(g.getPalabras_id()))
                );

        return grupos;
    }

    public List<Palabra> saveAll(String nameGrupo, List<Palabra> palabras) {
        nameGrupo = nameGrupo.toUpperCase();
        Grupo g = grupoRespository.findByNombre(nameGrupo);

        if(g == null){
            g = (Grupo) grupoService.save(new Grupo(nameGrupo));
        }

        palabras = (List<Palabra>) saveAll(palabras);

        for (Palabra p : palabras){
            g.getPalabras_id().add(p.getId());
        }

        grupoService.save(g);

        return palabras;
    }
}
