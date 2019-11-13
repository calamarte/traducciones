package ingles.traducciones.service;

import ingles.traducciones.entity.EntityInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public abstract class AbstractService<T extends EntityInterface>{

    private static final String SEQUENCE_EXTENSION = "_seq";

    @Autowired
    private SequenceService sequenceService;
    protected MongoRepository<T, Long> repository;

    protected AbstractService(MongoRepository<T, Long> repository){
        this.repository = repository;
    }

    public Optional<T> findById(Long id){
        return repository.findById(id);
    }

    public Iterable<T> findById(Iterable<Long> ids){
        return (Iterable<T>) repository.findAllById(ids);
    }

    public T save(T entity){
        if(entity.getId() == null){
            entity.setId(nextId(entity));
        }

        return repository.save(entity);
    }

    public Iterable<T> saveAll(Iterable<T> entities){
        entities.forEach(e -> {
            if(e.getId() == null){
                e.setId(nextId(e));
            }
        });

        return repository.saveAll(entities);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public void delete(T entity){
        repository.delete(entity);
    }

    public void deleteAll(Iterable<T> entities){
        repository.deleteAll(entities);
    }

    public Iterable<T> findAll(){
        return repository.findAll();
    }

    private Long nextId(T entity){
        return sequenceService.getNextValue(entity.getClass().getSimpleName() + SEQUENCE_EXTENSION);
    }
}
