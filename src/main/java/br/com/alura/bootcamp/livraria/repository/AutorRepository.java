package br.com.alura.bootcamp.livraria.repository;

import br.com.alura.bootcamp.livraria.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {


}