package br.com.alura.bootcamp.livraria.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private LocalDate dataLancamento;
    private Integer paginas;

    @ManyToOne
    private Autor autor;

    public Livro(String titulo, LocalDate dataLancamento, Integer paginas, Autor autor) {
        this.titulo = titulo;
        this.dataLancamento = dataLancamento;
        this.paginas = paginas;
        this.autor = autor;
    }

    public void atualizarInformacoes(String titulo, LocalDate dataLancamento, Integer paginas) {

        this.titulo = titulo;
        this.dataLancamento = dataLancamento;
        this.paginas = paginas;
    }
}
