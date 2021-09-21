package br.com.alura.bootcamp.livraria.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AutorFormDto {

    //Espelho da classe autor com todos os atributos para realizar o cadastro no sistema


    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private String miniCurriculo;

}