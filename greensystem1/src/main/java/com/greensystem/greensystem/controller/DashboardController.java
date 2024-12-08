package com.greensystem.greensystem.controller;

import com.greensystem.greensystem.models.entity.Armazenamento;
import com.greensystem.greensystem.models.repository.ArmazenamentoRepository;
import com.greensystem.greensystem.models.entity.Cliente;
import com.greensystem.greensystem.models.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ArmazenamentoRepository armazenamentoRepository;

    // Exibe o formulário de pesquisa de CNPJ
    @GetMapping("/dashboard")
    public String showDashboardForm() {
        return "dashboard";  // Nome do arquivo HTML (dashboard.html)
    }

    // Processa o CNPJ enviado pelo usuário
    @PostMapping("/dashboard")
    public String dashboard(@RequestParam("cnpj") String cnpj, Model model) {
        // Busca o cliente pelo CNPJ
        Cliente cliente = clienteRepository.findByCnpj(cnpj);
        
        if (cliente != null) {
            // Busca os dados de armazenamento do cliente
            List<Armazenamento> armazenamentoList = armazenamentoRepository.findByCliente(cliente);
            model.addAttribute("cliente", cliente);
            model.addAttribute("armazenamentoList", armazenamentoList);
        } else {
            model.addAttribute("error", "Cliente não encontrado com o CNPJ informado.");
        }

        return "dashboard";  // Nome do arquivo HTML (dashboard.html)
    }
}
