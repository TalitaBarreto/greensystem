package com.greensystem.greensystem.models.repository;

import com.greensystem.greensystem.models.entity.Armazenamento;
import com.greensystem.greensystem.models.entity.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArmazenamentoRepository extends JpaRepository<Armazenamento, Integer> {
    List<Armazenamento> findByCliente(Cliente cliente);
}

