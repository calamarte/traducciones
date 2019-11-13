package ingles.traducciones.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Document
public class Grupo implements EntityInterface{

    @Id
    private Long id;
    private String nombre;
    private Set<Long> palabras_id;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Palabra> palabras;

    public Grupo(){}

    public Grupo(String nombre){
        this.nombre = nombre.toUpperCase();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) {this.nombre = nombre.toUpperCase();}

    @JsonIgnore
    public Set<Long> getPalabras_id() {
        if(palabras_id == null){
            palabras_id = new HashSet();
        }

        return palabras_id;
    }

    public List<Palabra> getPalabras() {
        return palabras;
    }

    @JsonIgnore
    public void setPalabras(List<Palabra> palabras) {
        this.palabras = palabras;
    }
}
