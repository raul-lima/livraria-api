package br.com.alura.bootcamp.livraria.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LivroDto {

    private String titulo;
    private LocalDate dataLancamento;
    private Integer paginas;
    // Aqui usa o AutorDto de maneira proposital para esconder o atributo miniCurriculo, simulando o formulário do projeto 01
    private AutorDto autor;

}
