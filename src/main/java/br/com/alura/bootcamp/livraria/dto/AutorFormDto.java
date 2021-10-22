package br.com.alura.bootcamp.livraria.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    // Em data não pode usar @NotBlank ou @NotEmpty, tem que usar @NotNull (se não dá erro: No validator could be found for constraint 'javax.validation.constraints.NotEmpty' validating type 'java.util.Date')
    @NotNull
    private LocalDate dataNascimento;
    @NotBlank
    private String miniCurriculo;

}