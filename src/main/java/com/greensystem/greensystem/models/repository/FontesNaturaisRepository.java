package com.greensystem.greensystem.models.repository;

import com.greensystem.greensystem.models.entity.FontesNaturais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FontesNaturaisRepository extends JpaRepository<FontesNaturais, Integer> {
    
    // Busca fontes naturais por código de recurso (energia, água, etc.)
    List<FontesNaturais> findByCodRecursos(Integer codRecursos);
}
