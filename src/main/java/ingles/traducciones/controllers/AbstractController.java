package ingles.traducciones.controllers;

import ingles.traducciones.entity.EntityInterface;
import ingles.traducciones.service.AbstractService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public abstract class AbstractController<T extends EntityInterface> {

    protected AbstractService<T> service;

    protected AbstractController(AbstractService<T> service){
        this.service = service;
    }

    @PostMapping("/save")
    public T save(@RequestBody T entity){
        return (T) service.save(entity);
    }

    @PostMapping(value = "/save/all")
    public List<T> saveAll(@RequestBody List<T> entities){
       return (List<T>) service.saveAll(entities);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody T entity){
        service.delete(entity);
    }

    @DeleteMapping("/delete/all")
    public void deleteAll(@RequestBody List<T> entities){
        service.deleteAll(entities);
    }

    @DeleteMapping("/delete/id/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping("/id/{id}")
    public T findById(@PathVariable Long id){
        return (T) service.findById(id).orElse(null);
    }

    @GetMapping("/all")
    public List<T> findAll(){
        return (List<T>) service.findAll();
    }

}
