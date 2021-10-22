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

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

/**
 * The type Livro service.
 */
@Service
public class LivroService {


    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    private ModelMapper modelMapper = new ModelMapper();


    /**
     * Listar page.
     *
     * @param paginacao the paginacao
     * @return the page
     */
    public Page<LivroDto> listar(Pageable paginacao) {

        Page<Livro> livros = livroRepository.findAll(paginacao);

        return livros
                .map(l -> modelMapper.map(l, LivroDto.class));
    }

    /**
     * Cadastrar livro dto.
     *
     * @param dto the dto
     * @return the livro dto
     */
    @Transactional
    public LivroDto cadastrar(LivroFormDto dto) {

        try {
            Livro livro = modelMapper.map(dto, Livro.class);
            Autor autor = autorRepository.getById(dto.getAutorId());
            livro.setId(null);
            livro.setAutor(autor);

            livroRepository.save(livro);

            return modelMapper.map(livro, LivroDto.class);
        } catch (EntityNotFoundException e) {

            throw new IllegalArgumentException("usuario inexistente!");
        }

    }

}
