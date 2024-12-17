package com.greensystem.greensystem.models.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "metas")
public class Metas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codEmpresa", length = 14)
    private String codEmpresa;

    @ManyToOne
    @JoinColumn(name = "codRecursos", referencedColumnName = "codRecursos")
    private FontesNaturais fontesNaturais;

    @Column(name = "MetaEconomia")
    private Float metaEconomia;

    @Column(name = "EconomiaAtual")
    private Float economiaAtual;

    @Column(name = "data_inicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    @Column(name = "data_atual")
    @Temporal(TemporalType.DATE)
    private Date dataAtual;

    @Column(name = "data_final")
    @Temporal(TemporalType.DATE)
    private Date dataFinal;

    // Getters and Setters
    public String getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(String codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public FontesNaturais getFontesNaturais() {
        return fontesNaturais;
    }

    public void setFontesNaturais(FontesNaturais fontesNaturais) {
        this.fontesNaturais = fontesNaturais;
    }

    public Float getMetaEconomia() {
        return metaEconomia;
    }

    public void setMetaEconomia(Float metaEconomia) {
        this.metaEconomia = metaEconomia;
    }

    public Float getEconomiaAtual() {
        return economiaAtual;
    }

    public void setEconomiaAtual(Float economiaAtual) {
        this.economiaAtual = economiaAtual;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(Date dataAtual) {
        this.dataAtual = dataAtual;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }
}
