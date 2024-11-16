package com.greensystem.greensystem.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "armazenamento")
public class Armazenamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;  // Chave primária da tabela de armazenamento

    @Column(name = "codRecursos", nullable = true)
    private Integer codRecursos;  // Este campo não é uma chave estrangeira

    @Column(name = "codEmpresa", length = 14, nullable = true, columnDefinition = "VARCHAR(14) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci")
    private String codEmpresa;

    @Column(name = "gastos", nullable = true)
    private Float gastos;

    @Column(name = "coleta", nullable = true)
    private Float coleta;

    // Construtor padrão
    public Armazenamento() {}

    // Construtor com parâmetros
    public Armazenamento(Integer codRecursos, String codEmpresa, Float gastos, Float coleta) {
        this.codRecursos = codRecursos;
        this.codEmpresa = codEmpresa;
        this.gastos = gastos;
        this.coleta = coleta;
    }

    // Getters e Setters
    public Integer getCodRecursos() {
        return codRecursos;
    }

    public void setCodRecursos(Integer codRecursos) {
        this.codRecursos = codRecursos;
    }

    public String getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(String codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public Float getGastos() {
        return gastos;
    }

    public void setGastos(Float gastos) {
        this.gastos = gastos;
    }

    public Float getColeta() {
        return coleta;
    }

    public void setColeta(Float coleta) {
        this.coleta = coleta;
    }

    @Override
    public String toString() {
        return "Armazenamento{" +
               "id=" + id +
               ", codRecursos=" + codRecursos +
               ", codEmpresa='" + codEmpresa + '\'' +
               ", gastos=" + gastos +
               ", coleta=" + coleta +
               '}';
    }
}