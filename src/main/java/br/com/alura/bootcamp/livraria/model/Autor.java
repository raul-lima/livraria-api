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
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private String miniCurriculo;

    public Autor(String nome, String email, LocalDate dataNascimento, String miniCurriculo) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.miniCurriculo = miniCurriculo;
    }

    public void atualizarInformacoes(String nome, String email, LocalDate dataNascimento, String miniCurriculo) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.miniCurriculo = miniCurriculo;
    }
}