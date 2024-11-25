package com.greensystem.greensystem.models.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greensystem.greensystem.models.entity.FontesNaturais;

public interface FontesNaturaisRepository extends JpaRepository<FontesNaturais, Integer> {
    Optional<FontesNaturais> findByCodRecursos(Long codRecursos);
}
