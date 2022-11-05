package com.aptos.cadastrodeaptos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.aptos.cadastrodeaptos.model.Apartamento;
import com.aptos.cadastrodeaptos.model.Proprietario;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/novo_prop")
    public String exibeFormProp(Model model) {
        model.addAttribute("proprietario", new Proprietario());
        return "cad_prop";
    }

    @GetMapping("/novo_apto")
    public String exibeFormApto(Model model) {
        model.addAttribute("apartamento", new Apartamento());
        return "cad_apto";
    }

}
