package br.com.alura.bootcamp.livraria.controller;

import br.com.alura.bootcamp.livraria.dto.LoginFormDto;
import br.com.alura.bootcamp.livraria.dto.TokenDto;
import br.com.alura.bootcamp.livraria.infra.security.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AutenticacaoService service;

    @PostMapping
    public TokenDto autenticar(@RequestBody @Valid LoginFormDto dto){
        return new TokenDto (service.autenticar(dto)); // Devolve o token


    }
}
