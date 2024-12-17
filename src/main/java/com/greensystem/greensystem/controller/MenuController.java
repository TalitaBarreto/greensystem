package com.greensystem.greensystem.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.greensystem.greensystem.models.entity.Menu;

@Controller
public class MenuController {

        @GetMapping("/menu")
        public String index(Model model) {
            List<Menu> menuItems = Arrays.asList(
            new Menu("Cadastro de Empresas", "/cadastro"),
            new Menu("Cadastro de Metas", "/metas"),
            new Menu("Cadastro de Água e Energia", "/cadastroRecursos"),
            new Menu("Consultar dados", "/dashboard")
            
        );
        model.addAttribute("menuItems", menuItems);
        return "menu";
        }
}
