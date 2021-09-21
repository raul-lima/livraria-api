package br.com.alura.bootcamp.livraria.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Livro {


    private String titulo;
    private LocalDate dataLancamento;
    private Integer paginas;
    private Autor autor;
}
