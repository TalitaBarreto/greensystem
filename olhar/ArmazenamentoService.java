package com.greensystem.greensystem.models.service;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.greensystem.greensystem.models.entity.Armazenamento;
import com.greensystem.greensystem.models.entity.FontesNaturais;
import com.greensystem.greensystem.models.repository.ArmazenamentoRepository;
import com.greensystem.greensystem.models.repository.FontesNaturaisRepository;

@Service
public class ArmazenamentoService {

    private final ArmazenamentoRepository armazenamentoRepo;
    private final FontesNaturaisRepository fontesNaturaisRepo;

    
    public ArmazenamentoService(ArmazenamentoRepository armazenamentoRepo, FontesNaturaisRepository fontesNaturaisRepo) {
        this.armazenamentoRepo = armazenamentoRepo;
        this.fontesNaturaisRepo = fontesNaturaisRepo;
    }

    public boolean atualizarArmazenamento(String codEmpresa, Long codRecursos, Double gastos, Double coleta) {
        // Lógica de negócios: Verificar se a fonte natural existe
        Optional<FontesNaturais> fonte = fontesNaturaisRepo.findByCodRecursos(codRecursos);
        
        if (fonte.isPresent()) {
            // Adicionar ou atualizar o armazenamento
            Armazenamento armazenamento = new Armazenamento();
            armazenamento.setCodEmpresa(codEmpresa);
            armazenamento.setGastos(gastos);
            armazenamento.setColeta(coleta);
            armazenamentoRepo.save(armazenamento);
            return true;
        }
        
        return false;
    }
}
