package br.com.alura.bootcamp.livraria.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AutorDto {

    // Espelho da classe Autor, só que sem o miniCurriculo
    // Usada para mostrar só esses três atributos para o usuário e ocultar o miniCurriculo

    private String nome;
    private String email;
    private LocalDate dataNascimento;

}
