package com.greensystem.greensystem.models.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fontesnaturais")
public class FontesNaturais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codRecursos", nullable = false)
    private int codRecursos;

    @Column(name = "nome", length = 10, nullable = true, columnDefinition = "VARCHAR(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci")
    private String nome;

    // Construtor padrão
    public FontesNaturais() {}

    // Construtor com parâmetros
    public FontesNaturais(int codRecursos, String nome) {
        this.codRecursos = codRecursos;
        this.nome = nome;
    }

    // Getters e Setters
    public int getCodRecursos() {
        return codRecursos;
    }

    public void setCodRecursos(int codRecursos) {
        this.codRecursos = codRecursos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}