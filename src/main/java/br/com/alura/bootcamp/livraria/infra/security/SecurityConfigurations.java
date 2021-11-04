package br.com.alura.bootcamp.livraria.infra.security;

import br.com.alura.bootcamp.livraria.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    // Quem chama a service é o spring por conta desta configuração
    // Configura o controle de autenticação
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(autenticacaoService)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    // Configura as urls e o mecanismo de autenticação, se é stateless ou não
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/auth").permitAll() // Autoriza acessar o /auth sem precisar autenticar antes. Ou seja, não precisa estar logado para tentar logar
                .antMatchers("/usuarios/**").hasRole("ADMIN")
                .anyRequest().authenticated() // qualquer requisição precisa estar logado
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //indica pro string que o gerenciamento de sessão é stateless. Cria a necessidade de fazer um controller de autenticação, porque não está mais usando o do spring
                .and().csrf().disable() //desabilita a proteção automática do spring para requisições do tipo post
                .addFilterBefore(
                        new VerificacaoTokenFilter(tokenService, usuarioRepository),
                        UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    // Ignorar recursos estáticos da aplicação
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**");
    }
}
