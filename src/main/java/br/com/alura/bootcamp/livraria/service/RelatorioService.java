package br.com.alura.bootcamp.livraria.service;

import br.com.alura.bootcamp.livraria.dto.LivrosPorAutorDto;
import br.com.alura.bootcamp.livraria.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioService {

    @Autowired
    private LivroRepository repository;


    public List<LivrosPorAutorDto> relatorioLivrosPorAutor() {

        return repository.relatorioLivrosPorAutor();
    }
}
