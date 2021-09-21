package br.com.alura.bootcamp.livraria.service;

import br.com.alura.bootcamp.livraria.dto.LivroDto;
import br.com.alura.bootcamp.livraria.dto.LivroFormDto;
import br.com.alura.bootcamp.livraria.model.Livro;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {

    private List<Livro> livros = new ArrayList<>();

    private ModelMapper modelMapper = new ModelMapper();

    @GetMapping
    public List<LivroDto> listar() {

        return livros
                .stream()
                .map(l -> modelMapper.map(l, LivroDto.class))
                .collect(Collectors.toList());
    }

    @PostMapping
    public void cadastrar(LivroFormDto dto) {

        Livro livro = modelMapper.map(dto, Livro.class);

        livros.add(livro);

    }

}
