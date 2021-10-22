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


    // Deve retornar uma lista de autores, a quantidade de livros de cada autor que constam na biblioteca e a porcentagem
    // que cada autor ocupa na composição do acervo
    public List<LivrosPorAutorDto> relatorioLivrosPorAutor() {

        return repository.relatorioLivrosPorAutor();
    }
}
