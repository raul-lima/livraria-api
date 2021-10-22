package br.com.alura.bootcamp.livraria.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
// Como aqui não usou o @DataJpaTest, tem que passar o @Transactional para ele fazer o rollback automático depois de cada teste
@Transactional
class AutorControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void naoDeveriaCadastrarAutorComDadosIncompletos() throws Exception {

        String json = "{}";

        mvc
                .perform(
                        post("/autores")
                .contentType(MediaType.APPLICATION_JSON)
                                .content(json))
                .andExpect(status().isBadRequest());

    }

    @Test
    void deveriaCadastrarAutorComDadosIncompletos() throws Exception {

        String json = "{\"nome\":\"Raul\",\"email\":\"raul@gmail.com\",\"dataNascimento\":\"1993-04-25\",\"miniCurriculo\":\"curriculo\"}";

        mvc
                .perform(
                        post("/autores")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(content().json(json));

    }

}