package br.com.alura.bootcamp.livraria.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LivroFormDto {

    @NotBlank
    @Size(min = 10)
    private String titulo;
    @PastOrPresent
    private LocalDate dataLancamento;
    @Min(100)
    private Integer paginas;

    @JsonAlias("autor_id")
    private Long autorId;
}
