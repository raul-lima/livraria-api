package br.com.alura.bootcamp.livraria.repository;

import br.com.alura.bootcamp.livraria.model.Perfil;
import br.com.alura.bootcamp.livraria.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface PerfilRepository extends JpaRepository<Perfil, Long> {


}

