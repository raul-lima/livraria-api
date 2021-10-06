package br.com.alura.bootcamp.livraria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LivrosPorAutorDto {

    private String autor;
    private Long quantidadeLivros;
    private Double percentual;
}
