package br.com.alura.bootcamp.livraria.service;

import br.com.alura.bootcamp.livraria.dto.LivroDto;
import br.com.alura.bootcamp.livraria.dto.LivroFormDto;
import br.com.alura.bootcamp.livraria.model.Autor;
import br.com.alura.bootcamp.livraria.model.Livro;
import br.com.alura.bootcamp.livraria.repository.AutorRepository;
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
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    private ModelMapper modelMapper = new ModelMapper();


    public Page<LivroDto> listar(Pageable paginacao) {

        Page<Livro> livros = livroRepository.findAll(paginacao);

        return livros
                .map(l -> modelMapper.map(l, LivroDto.class));
    }

    @Transactional
    public LivroDto cadastrar(LivroFormDto dto) {

        Livro livro = modelMapper.map(dto, Livro.class);
        Autor autor = autorRepository.getById(dto.getAutorId());

        livro.setId(null);
        livro.setAutor(autor);

        livroRepository.save(livro);

        return modelMapper.map(livro, LivroDto.class);

    }

}
