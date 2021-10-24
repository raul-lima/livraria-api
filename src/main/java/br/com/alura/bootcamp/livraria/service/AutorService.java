package br.com.alura.bootcamp.livraria.service;

import br.com.alura.bootcamp.livraria.dto.AtualizacaoAutorFormDto;
import br.com.alura.bootcamp.livraria.dto.AutorDto;
import br.com.alura.bootcamp.livraria.dto.AutorFormDto;
import br.com.alura.bootcamp.livraria.dto.LivroDto;
import br.com.alura.bootcamp.livraria.model.Autor;
import br.com.alura.bootcamp.livraria.model.Livro;
import br.com.alura.bootcamp.livraria.repository.AutorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

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
    public AutorDto cadastrar(AutorFormDto dto) {

        Autor autor = modelMapper.map(dto, Autor.class);

        autor.setId(null);

        autorRepository.save(autor);

        return modelMapper.map(autor, AutorDto.class);

    }

    @Transactional
    public AutorDto atualizar(AtualizacaoAutorFormDto dto) {

        Autor autor = autorRepository.getById(dto.getId());

        autor.atualizarInformacoes(dto.getNome(), dto.getEmail(), dto.getDataNascimento(), dto.getMiniCurriculo());
        return modelMapper.map(autor, AutorDto.class);
    }

    @Transactional
    public void remover(Long id) {
        autorRepository.deleteById(id);

    }

    public AutorDto detalhar(Long id) {
        Autor autor = autorRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
        return modelMapper.map(autor, AutorDto.class);
    }
}
