package br.com.alura.bootcamp.livraria.repository;

import br.com.alura.bootcamp.livraria.dto.LivrosPorAutorDto;
import br.com.alura.bootcamp.livraria.model.Autor;
import br.com.alura.bootcamp.livraria.model.Livro;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class LivroRepositoryTest {

    @Autowired
    private LivroRepository repository;

    @Autowired
    private TestEntityManager em;

    @Test
    void deveriaRetornarRelatorioLivrosPorAutor() {

        Autor autor = new Autor("Raul Lima",
                "raul@gmail.com",
                LocalDate.now(),
                "curriculo");

        em.persist(autor);

        Autor autor2 = new Autor("Luis Cláudio",
                "luis@gmail.com",
                LocalDate.now(),
                "curriculo");

        em.persist(autor2);

        Livro l1 = new Livro(
                "titulolivro1",
                LocalDate.now(),
                150,
                autor
        );

        em.persist(l1);

        Livro l2 = new Livro(
                "titulolivro2",
                LocalDate.now(),
                180,
                autor2
        );
        em.persist(l2);

        Livro l3 = new Livro(
                "titulolivro3",
                LocalDate.now(),
                200,
                autor
        );
        em.persist(l3);

        Livro l4 = new Livro(
                "titulolivro4",
                LocalDate.now(),
                250,
                autor2
        );
        em.persist(l4);

        Livro l5 = new Livro(
                "titulolivro5",
                LocalDate.now(),
                300,
                autor
        );

        em.persist(l5);

        List<LivrosPorAutorDto> relatorio = repository.relatorioLivrosPorAutor();

        // Biblioteca assertJ, não são os assertions normais do Junit. Tomar cuidado na hora de importar
        Assertions.assertThat(relatorio)
                .hasSize(2)
                .extracting(LivrosPorAutorDto::getAutor, LivrosPorAutorDto::getQuantidadeLivros, LivrosPorAutorDto::getPercentual)
                .containsExactlyInAnyOrder(
                        Assertions.tuple("Raul Lima", 3l, 0.6 ),
                        Assertions.tuple("Luis Cláudio", 2l, 0.4)
                );


    }
}