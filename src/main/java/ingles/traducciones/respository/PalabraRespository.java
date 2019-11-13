package ingles.traducciones.respository;

import ingles.traducciones.entity.Palabra;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PalabraRespository extends MongoRepository<Palabra, Long> {

}
