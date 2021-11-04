package br.com.alura.bootcamp.livraria.infra.security;

import br.com.alura.bootcamp.livraria.dto.LoginFormDto;
import br.com.alura.bootcamp.livraria.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// Ensina o spring como é a autenticação neste projeto
@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
     private UsuarioRepository repository;

    // AuthenticationManager não aceita Autowired. É uma interface, então não dá pra dar new.
    // A solução: fazer um @override do método AuthenticationManager na classe SecurityConfigurations que extends WebSecurityConfigureAdapter e colocar @Bean
    // Isso porque WebSecurityConfigureAdapter já implementa esse método
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository
                .findByLogin(username)
                // Como o retorno do método findByLogin é optional, se não achar usuário vai jogar uma exception
                .orElseThrow(() -> new UsernameNotFoundException(""));
    }

    public String autenticar(LoginFormDto dto) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                dto.getLogin(),
                dto.getSenha()
        );
        authentication = authenticationManager.authenticate(authentication);

        return tokenService.gerarToken(authentication);
        // autenticar, gerar token e devolver token
        // token: eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxIn0.MNi2k_yDT2GhVorcHRe59wA-aTSXUjtHtdnFrTpVGW0
    }
}
