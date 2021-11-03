package br.com.alura.bootcamp.livraria.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    // Quem chama a service é o spring por conta desta configuração
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(autenticacaoService)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated() // qualquer requisição precisa estar logado
                .and().formLogin()
                .and().csrf().disable(); //desabilita a proteção automática do spring para requisições do tipo post
    }
}
