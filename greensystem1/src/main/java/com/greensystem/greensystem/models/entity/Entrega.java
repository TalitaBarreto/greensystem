package com.greensystem.greensystem.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "entrega")
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codEntrega")
    private Integer codEntrega;

    @ManyToOne
    @JoinColumn(name = "cnpj")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "codEquipamento")
    private Equipamento equipamento;

    // Getters e Setters
    public Integer getCodEntrega() {
        return codEntrega;
    }

    public void setCodEntrega(Integer codEntrega) {
        this.codEntrega = codEntrega;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }
}
