package br.com.alura.bootcamp.livraria.controller;

import br.com.alura.bootcamp.livraria.dto.LivroDto;
import br.com.alura.bootcamp.livraria.dto.LivroFormDto;
import br.com.alura.bootcamp.livraria.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

// RestController Serve para especificar que é um controller do tipo Rest, que não devolve páginas JSP e sim o formato padrão JSON
@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService service;

    @GetMapping
    public Page<LivroDto> listar(@PageableDefault(size = 10) Pageable paginacao) {

        return service.listar(paginacao);
    }

    @PostMapping
    public ResponseEntity<LivroDto> cadastrar(@RequestBody @Valid LivroFormDto dto, UriComponentsBuilder uriBuilder) {

        LivroDto livroDto = service.cadastrar(dto);

        URI uri = uriBuilder.path("/livros/{id}").buildAndExpand(livroDto.getId()).toUri();

        return ResponseEntity.created(uri).body(livroDto);

    }

}
