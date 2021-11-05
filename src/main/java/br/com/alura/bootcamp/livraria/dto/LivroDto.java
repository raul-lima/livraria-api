package br.com.alura.bootcamp.livraria.dto;

import br.com.alura.bootcamp.livraria.model.Autor;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LivroDto {

    private Long id;
    private String titulo;
    private LocalDate dataLancamento;
    private Integer paginas;
    private Autor autor;

}
