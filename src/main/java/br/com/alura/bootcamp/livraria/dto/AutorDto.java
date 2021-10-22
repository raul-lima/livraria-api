package br.com.alura.bootcamp.livraria.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AutorDto {

    private Long id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private String miniCurriculo;
}
