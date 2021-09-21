package br.com.alura.bootcamp.livraria.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Autor {

    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private String miniCurriculo;

}