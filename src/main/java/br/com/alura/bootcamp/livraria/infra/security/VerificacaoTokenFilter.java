package br.com.alura.bootcamp.livraria.infra.security;

import br.com.alura.bootcamp.livraria.model.Usuario;
import br.com.alura.bootcamp.livraria.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class VerificacaoTokenFilter extends OncePerRequestFilter {

    private TokenService tokenService;

    private UsuarioRepository usuarioRepository;

    public VerificacaoTokenFilter(TokenService tokenService, UsuarioRepository usuarioRepository) {
        this.tokenService = tokenService;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        // Tem que ser esse nome Authorization para pegar o Header da requisição
        String token = request.getHeader("Authorization");

        if (token == null || token.isBlank()){
            // Segue o fluxo sem logar o usuário
            filterChain.doFilter(request, response);
            // sai do filter
            return;
        }

        // O cabeçalho vem com "Bearer" antes do token, separado por um espaço. Por isso, tem que retirar o Bearer:
        token = token.replace("Bearer ", "");

        boolean tokenValido = tokenService.isValid(token);

        if (tokenValido) {

            Long idUsuario = tokenService.extrairIdUsuario(token);
            Usuario logado = usuarioRepository.carregarPorIdComPerfis(idUsuario).get();
            Authentication authentication = new UsernamePasswordAuthenticationToken(logado, null, logado.getAuthorities());
            // Fala pro Spring que o usuário tá autenticado
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }
}
