package br.com.alura.bootcamp.livraria.controller;

import br.com.alura.bootcamp.livraria.dto.AutorDto;
import br.com.alura.bootcamp.livraria.dto.AutorFormDto;
import br.com.alura.bootcamp.livraria.model.Autor;
import br.com.alura.bootcamp.livraria.service.AutorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

// RestController Serve para especificar que é um controller do tipo Rest, que não devolve páginas JSP e sim o formato padrão JSON
@RestController
@RequestMapping("/autores")
public class AutorController {

    private List<Autor> autores = new ArrayList<>();

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private AutorService service;

    @GetMapping
    public List<AutorDto> listar() {

        return service.listar();
    }

    @PostMapping
    public void cadastrar(@RequestBody @Valid AutorFormDto dto) {

        service.cadastrar(dto);

    }

}
