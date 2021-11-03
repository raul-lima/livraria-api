package br.com.alura.bootcamp.livraria.infra.security;

import br.com.alura.bootcamp.livraria.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// Ensina o spring como é a autenticação neste projeto
@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
     private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository
                .findByLogin(username)
                // Como o retorno do método findByLogin é optional, se não achar usuário vai jogar uma exception
                .orElseThrow(() -> new UsernameNotFoundException(""));
    }
}
