package com.greensystem.greensystem.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "armazenamento")
public class Armazenamento {

    @Id
    @Column(name = "codRecursos")
    private int recurso;

    @ManyToOne
    @JoinColumn(name = "codEmpresa", referencedColumnName = "cnpj")
    private Cliente cliente;

    private double gastos;
    private double coleta;

    // Getters e Setters
    public int getRecurso() { return recurso; }
    public void setRecurso(int recurso) { this.recurso = recurso; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public double getGastos() { return gastos; }
    public void setGastos(double gastos) { this.gastos = gastos; }

    public double getColeta() { return coleta; }
    public void setColeta(double coleta) { this.coleta = coleta; }
}


