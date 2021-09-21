package br.com.alura.bootcamp.livraria.controller;

import br.com.alura.bootcamp.livraria.model.Autor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private List<Autor> autores = new ArrayList<>();

    @GetMapping
    public List<Autor> listar(){

        return autores;
    }

    @PostMapping
    public void cadastrar(@RequestBody Autor autor){

        autores.add(autor);

    }

}
