package ingles.traducciones.controllers;

import ingles.traducciones.entity.Grupo;
import ingles.traducciones.entity.Palabra;
import ingles.traducciones.respository.GrupoRespository;
import ingles.traducciones.respository.PalabraRespository;
import ingles.traducciones.service.GrupoService;
import ingles.traducciones.service.PalabraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class Test {

    @Autowired
    private PalabraRespository palabraRespository;

    @Autowired
    private GrupoRespository grupoRespository;

    @Autowired
    private GrupoService grupoService;

    @Autowired
    private PalabraService palabraService;

    @GetMapping(value = "/init")
    public  String initData(){
        String[] grupos = {"Jardin", "muebles", "animales"};
        List<Palabra> result = new ArrayList();

        List<Palabra> palabras;
        for (String s : grupos) {
            palabras = new ArrayList<>();

            for (int i = 0; i < 100; i++) {
                palabras.add(new Palabra(randomString(), randomString()));
            }

            result.addAll(palabraService.saveAll(s, palabras));
        }


        String response = Arrays.toString(result.toArray());
        System.out.println(response);
        return response;
    }

    @GetMapping(value = "/delete")
    public String deleteAll(){
        grupoRespository.deleteAll();
        palabraRespository.deleteAll();
        return "ok";
    }

    @GetMapping(value = "/grupos")
    public List<Grupo> getGrupos(){
        return grupoRespository.findAll();
    }

    private String randomString(){
        String all = "qwertyuiopasdfghjklñzxcvbnm";
        Random rand = new Random();

        int n;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            n = rand.nextInt(all.length());
            sb.append(all.charAt(n));
        }

        return sb.toString();
    }
}
