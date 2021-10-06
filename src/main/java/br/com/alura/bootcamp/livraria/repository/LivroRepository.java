package br.com.alura.bootcamp.livraria.repository;

import br.com.alura.bootcamp.livraria.dto.LivrosPorAutorDto;
import br.com.alura.bootcamp.livraria.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query("select new br.com.alura.bootcamp.livraria.dto.LivrosPorAutorDto(l.autor.nome, count(*), " +
            "count(*) * 1.0 / (select count(*) from Livro l2) * 1.0 as percentual) " +
            "from Livro l group by l.autor order by percentual desc")
    List<LivrosPorAutorDto> relatorioLivrosPorAutor();

}