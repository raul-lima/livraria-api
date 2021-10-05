package br.com.alura.bootcamp.livraria.repository;

import br.com.alura.bootcamp.livraria.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LivroRepository extends JpaRepository<Livro, Long> {


}