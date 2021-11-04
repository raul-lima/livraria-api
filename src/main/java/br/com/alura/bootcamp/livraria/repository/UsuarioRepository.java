package br.com.alura.bootcamp.livraria.repository;

import br.com.alura.bootcamp.livraria.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByLogin(String login);

    @Query("select u from Usuario u join fetch u.perfis where u.id = :id")
    Optional<Usuario> carregarPorIdComPerfis(Long id);
}

