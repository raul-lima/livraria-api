package br.com.alura.bootcamp.livraria.service;

import br.com.alura.bootcamp.livraria.dto.LivroDto;
import br.com.alura.bootcamp.livraria.dto.LivroFormDto;
import br.com.alura.bootcamp.livraria.model.Livro;
import br.com.alura.bootcamp.livraria.repository.LivroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {


    @Autowired
    LivroRepository livroRepository;

    private ModelMapper modelMapper = new ModelMapper();


    public List<LivroDto> listar() {

        List<Livro> livros = livroRepository.findAll();

        return livros
                .stream()
                .map(l -> modelMapper.map(l, LivroDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public void cadastrar(LivroFormDto dto) {

        Livro livro = modelMapper.map(dto, Livro.class);

        livro.setId(null);

        livroRepository.save(livro);

    }

}
