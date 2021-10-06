package br.com.alura.bootcamp.livraria.controller;

import br.com.alura.bootcamp.livraria.dto.AutorDto;
import br.com.alura.bootcamp.livraria.dto.AutorFormDto;
import br.com.alura.bootcamp.livraria.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

// RestController Serve para especificar que é um controller do tipo Rest, que não devolve páginas JSP e sim o formato padrão JSON
@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService service;

    @GetMapping
    public Page<AutorDto> listar(@PageableDefault(size = 10) Pageable paginacao) {

        return service.listar(paginacao);
    }

    @PostMapping
    public void cadastrar(@RequestBody @Valid AutorFormDto dto) {

        service.cadastrar(dto);

    }

}
