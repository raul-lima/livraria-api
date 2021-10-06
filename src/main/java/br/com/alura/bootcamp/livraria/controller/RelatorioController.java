package br.com.alura.bootcamp.livraria.controller;

import br.com.alura.bootcamp.livraria.dto.LivrosPorAutorDto;
import br.com.alura.bootcamp.livraria.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    @Autowired
    private RelatorioService service;

    @GetMapping("/livraria")
    public List<LivrosPorAutorDto> relatorioLivrosPorAutor() {

        return service.relatorioLivrosPorAutor();
    }

}
