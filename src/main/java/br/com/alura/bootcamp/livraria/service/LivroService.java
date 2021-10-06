package br.com.alura.bootcamp.livraria.service;

import br.com.alura.bootcamp.livraria.dto.LivroDto;
import br.com.alura.bootcamp.livraria.dto.LivroFormDto;
import br.com.alura.bootcamp.livraria.model.Livro;
import br.com.alura.bootcamp.livraria.repository.LivroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class LivroService {


    @Autowired
    LivroRepository livroRepository;

    private ModelMapper modelMapper = new ModelMapper();


    public Page<LivroDto> listar(Pageable paginacao) {

        Page<Livro> livros = livroRepository.findAll(paginacao);

        return livros
                .map(l -> modelMapper.map(l, LivroDto.class));
    }

    @Transactional
    public void cadastrar(LivroFormDto dto) {

        Livro livro = modelMapper.map(dto, Livro.class);

        livro.setId(null);

        livroRepository.save(livro);

    }

}
