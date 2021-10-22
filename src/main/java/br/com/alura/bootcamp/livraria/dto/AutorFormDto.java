package br.com.alura.bootcamp.livraria.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AutorFormDto {

    //Espelho da classe autor com todos os atributos para realizar o cadastro no sistema


    @NotBlank
    private String nome;
    @NotBlank
    private String email;
    @NotBlank
    private LocalDate dataNascimento;
    private String miniCurriculo;

}