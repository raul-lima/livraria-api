package br.com.alura.bootcamp.livraria.service;

import br.com.alura.bootcamp.livraria.dto.LivroDto;
import br.com.alura.bootcamp.livraria.dto.LivroFormDto;
import br.com.alura.bootcamp.livraria.model.Autor;
import br.com.alura.bootcamp.livraria.model.Livro;
import br.com.alura.bootcamp.livraria.repository.AutorRepository;
import br.com.alura.bootcamp.livraria.repository.LivroRepository;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class LivroServiceTest {

    @Mock
    private LivroRepository livroRepository;

    @Mock
    private AutorRepository autorRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private LivroService service;

    @Test
    void deveriaCadastrarUmLivro() {

        LivroFormDto formDto = criarLivroFormDto();

        Autor autor = new Autor("teste", "teste", LocalDate.now(), "teste");

        Livro livro = new Livro(formDto.getTitulo(), formDto.getDataLancamento(),
                formDto.getPaginas(), autor);

        Mockito.when(modelMapper.map(formDto, Livro.class)).thenReturn(livro);


        Mockito.when(modelMapper.map(livro, LivroDto.class)).thenReturn(new LivroDto(
                null,
                livro.getTitulo(),
                livro.getDataLancamento(),
                livro.getPaginas(),
                livro.getAutor()
        ));


        LivroDto dto = service.cadastrar(formDto);

        Mockito.verify(livroRepository).save(Mockito.any());

        assertEquals(formDto.getTitulo(), dto.getTitulo());
        assertEquals(formDto.getDataLancamento(), dto.getDataLancamento());
        assertEquals(formDto.getPaginas(), dto.getPaginas());

    }


    @Test
    void naoDeveriaCadastrarUmLivroComAutorInexistente() {

        LivroFormDto formDto = criarLivroFormDto();

        Mockito.when(autorRepository.getById(formDto.getAutorId()))
                .thenThrow(EntityNotFoundException.class);

        assertThrows(IllegalArgumentException.class, () -> service.cadastrar(formDto));

    }

    private LivroFormDto criarLivroFormDto() {
        return new LivroFormDto(
                "titulolivro",
                LocalDate.now(),
                150,
                1l
        );
    }


}