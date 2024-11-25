package com.greensystem.greensystem.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greensystem.greensystem.models.entity.Armazenamento;

public interface ArmazenamentoRepository extends JpaRepository<Armazenamento, Integer> {
}