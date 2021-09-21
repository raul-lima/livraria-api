package br.com.alura.bootcamp.livraria.service;

import br.com.alura.bootcamp.livraria.dto.AutorDto;
import br.com.alura.bootcamp.livraria.dto.AutorFormDto;
import br.com.alura.bootcamp.livraria.model.Autor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorService {

    private List<Autor> autores = new ArrayList<>();

    private ModelMapper modelMapper = new ModelMapper();

    @GetMapping
    public List<AutorDto> listar() {

        return autores
                .stream()
                .map(a -> modelMapper.map(a, AutorDto.class))
                .collect(Collectors.toList());
    }

    @PostMapping
    public void cadastrar(AutorFormDto dto) {

        Autor autor = modelMapper.map(dto, Autor.class);

        autores.add(autor);

    }

}
