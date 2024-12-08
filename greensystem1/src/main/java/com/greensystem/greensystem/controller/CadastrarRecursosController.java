package com.greensystem.greensystem.controller;

import com.greensystem.greensystem.models.service.CadastroRecursosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CadastrarRecursosController {

    @Autowired
    private CadastroRecursosService cadastroService;

    // Exibe o formulário de cadastro
    @GetMapping("/cadastroRecursos")
    public String showCadastroForm() {
        return "cadastroRecursos";  // Nome do arquivo HTML do formulário de cadastro
    }

    // Processa o cadastro do recurso
    @PostMapping("/cadastroRecursos")
    public String cadastrarRecurso(
            @RequestParam("cnpj") String cnpj,
            @RequestParam("recurso") String recurso,
            @RequestParam("gastos") Double gastos,
            @RequestParam("coleta") Double coleta,
            Model model) {

        // Verifica se o parâmetro 'recurso' está presente e válido
        if (recurso == null || recurso.trim().isEmpty()) {
            model.addAttribute("error", "O parâmetro 'recurso' é obrigatório.");
            return "cadastroRecursos";
        }

        // Verifica se o parâmetro 'gastos' e 'coleta' estão presentes
        if (gastos == null || coleta == null) {
            model.addAttribute("error", "Os parâmetros 'gastos' e 'coleta' são obrigatórios.");
            return "cadastroRecursos";
        }

        String message;
        if ("água".equalsIgnoreCase(recurso)) {
            message = cadastroService.cadastrarRecursoAgua(cnpj, gastos, coleta);
        } else if ("energia".equalsIgnoreCase(recurso)) {
            message = cadastroService.cadastrarRecursoEnergia(cnpj, gastos, coleta);
        } else {
            message = "Tipo de recurso inválido. Selecione 'água' ou 'energia'.";
        }

        // Exibe a mensagem de sucesso ou erro
        if (message.contains("sucesso")) {
            model.addAttribute("message", message);
        } else {
            model.addAttribute("error", message);
        }

        return "cadastroRecursos";
    }
}



