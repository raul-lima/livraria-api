package br.com.alura.bootcamp.livraria.service;

import br.com.alura.bootcamp.livraria.dto.LivroDto;
import br.com.alura.bootcamp.livraria.dto.LivroFormDto;
import br.com.alura.bootcamp.livraria.repository.AutorRepository;
import br.com.alura.bootcamp.livraria.repository.LivroRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LivroServiceTest {

    @Mock
    private LivroRepository livroRepository;

    @Mock
    private AutorRepository autorRepository;

    @InjectMocks
    private LivroService service;

    @Test
    void deveriaCadastrarUmLivro() {

        LivroFormDto formDto = new LivroFormDto(
                "titulolivro",
                LocalDate.now(),
                150,
                1l
        );


        LivroDto dto = service.cadastrar(formDto);

        Mockito.verify(livroRepository).save(Mockito.any());

        assertEquals(formDto.getTitulo(), dto.getTitulo());
        assertEquals(formDto.getDataLancamento(), dto.getDataLancamento());
        assertEquals(formDto.getPaginas(), dto.getPaginas());

    }

    @Test
    void naoDeveriaCadastrarUmLivroComAutorInexistente() {

        LivroFormDto formDto = new LivroFormDto(
                "titulolivro",
                LocalDate.now(),
                150,
                1l
        );


        Mockito.when(autorRepository.getById(formDto.getAutorId()))
                .thenThrow(EntityNotFoundException.class);

        assertThrows(IllegalArgumentException.class, () -> service.cadastrar(formDto));

    }



}