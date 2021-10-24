package br.com.alura.bootcamp.livraria.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AtualizacaoLivroFormDto extends LivroFormDto {

    @NotNull
    private Long id;

}
