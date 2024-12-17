package com.greensystem.greensystem.models.service;

import com.greensystem.greensystem.models.entity.Armazenamento;
import com.greensystem.greensystem.models.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArmazenamentoService {

    @Autowired
    private ArmazenamentoRepository armazenamentoRepository;

    public List<Armazenamento> listarTodos() {
        return armazenamentoRepository.findAll();
    }

    public Optional<Armazenamento> buscarPorId(int id) {
        return armazenamentoRepository.findById(id);
    }

    public Armazenamento salvar(Armazenamento armazenamento) {
        return armazenamentoRepository.save(armazenamento);
    }

    public void excluir(int id) {
        armazenamentoRepository.deleteById(id);
    }
}