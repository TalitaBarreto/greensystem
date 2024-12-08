package com.greensystem.greensystem.controller;

import com.greensystem.greensystem.models.entity.Cliente;
import com.greensystem.greensystem.models.service.CadastroClienteService;
import com.greensystem.greensystem.models.service.ClienteValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CadastrarClienteController {

    @Autowired
    private ClienteValidationService validationService;

    @Autowired
    private CadastroClienteService cadastroService;

    // Exibe o formulário de cadastro
    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro"; // Retorna a página cadastro.html
    }

    @PostMapping("/cadastro")
    public String cadastrarCliente(@RequestParam String cnpj,
                                @RequestParam String nome,
                                @RequestParam String endereco,
                                @RequestParam String telefone1,
                                @RequestParam String telefone2,
                                @RequestParam String telefone3,
                                @RequestParam String login,
                                @RequestParam String senha,
                                @RequestParam String senhaConfirmacao, // Adiciona a confirmação da senha
                                Model model) {

        // Verifica se as senhas são iguais utilizando o serviço de validação
        if (!validationService.verificarSenhasIguais(senha, senhaConfirmacao)) {
            model.addAttribute("error", "As senhas não coincidem.");
            return "cadastro";  // Retorna para a página de cadastro com erro
        }

        // Verifica se o login já está cadastrado
        if (validationService.isLoginJaExistente(login)) {
            model.addAttribute("error", "Este login já está em uso.");
            return "cadastro";  // Retorna para a página de cadastro com erro
        }

        // Verifica se o CNPJ já está cadastrado
        if (validationService.isCnpjJaExistente(cnpj)) {
            model.addAttribute("error", "Este CNPJ já está cadastrado.");
            return "cadastro";  // Retorna para a página de cadastro com erro
        }

        // Cria um novo cliente
        Cliente novoCliente = new Cliente();
        novoCliente.setCnpj(cnpj);
        novoCliente.setNome(nome);
        novoCliente.setEndereco(endereco);
        novoCliente.setTelefone1(telefone1);
        novoCliente.setTelefone2(telefone2);
        novoCliente.setTelefone3(telefone3);
        novoCliente.setLogin(login);
        novoCliente.setSenha(senha);

        // Chama o serviço para salvar o novo cliente no banco de dados
        cadastroService.salvarCliente(novoCliente);

        // Redireciona para a página de login após o cadastro
        return "redirect:/login";
    }
}





