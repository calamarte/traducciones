package ingles.traducciones.respository;

import ingles.traducciones.entity.Grupo;
import ingles.traducciones.entity.Palabra;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GrupoRespository extends MongoRepository<Grupo, Long> {

    public Grupo findByNombre(String nombre);

}
