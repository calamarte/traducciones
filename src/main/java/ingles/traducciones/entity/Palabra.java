package ingles.traducciones.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Palabra implements EntityInterface{

    @Id
    private Long id;

    private String es;
    private String en;

    public Palabra(String es, String en){
        this.es = es;
        this.en = en;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEs() {
        return es;
    }

    public void setEs(String es) {
        this.es = es;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    @Override
    public String toString() {
        return "Palabra{" +
                "id=" + id +
                ", es='" + es + '\'' +
                ", en='" + en + '\'' +
                '}';
    }
}
