package br.com.alura.bootcamp.livraria.service;

import br.com.alura.bootcamp.livraria.dto.AutorDto;
import br.com.alura.bootcamp.livraria.dto.AutorFormDto;
import br.com.alura.bootcamp.livraria.model.Autor;
import br.com.alura.bootcamp.livraria.repository.AutorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    private ModelMapper modelMapper = new ModelMapper();


    public Page<AutorDto> listar(Pageable paginacao) {

        Page<Autor> autores = autorRepository.findAll(paginacao);

        return autores.map(a -> modelMapper.map(a, AutorDto.class));
    }

    @Transactional
    public void cadastrar(AutorFormDto dto) {

        Autor autor = modelMapper.map(dto, Autor.class);

        autorRepository.save(autor);

    }

}
