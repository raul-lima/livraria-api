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
public class AtualizacaoAutorFormDto extends AutorFormDto{

    @NotNull
    private Long id;
}