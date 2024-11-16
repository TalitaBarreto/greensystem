package com.greensystem.greensystem.controller;

import com.greensystem.greensystem.models.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping({"/index", "/home", "/", "login"})
    public String login() {
        return "login";  // Nome do arquivo HTML (login.html)
    }

    @PostMapping("/login")
    public String login(@RequestParam String login,
                        @RequestParam String senha, Model model) {
    
        // Verifica se o login e a senha são válidos
        if (userService.autenticarUsuario(login, senha)) {
            return "redirect:/menu";  // Redireciona para a página principal após o login
        } else {
            model.addAttribute("error", "Usuário ou senha incorretos");
            return "login";  // Retorna para a página de login com mensagem de erro
        }
    }
}

