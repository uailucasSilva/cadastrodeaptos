package com.aptos.cadastrodeaptos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.aptos.cadastrodeaptos.model.Apartamento;
import com.aptos.cadastrodeaptos.model.Proprietario;

@Controller
public class HomeController {

    @Autowired
    JdbcTemplate db;

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
        // trecho de código para alimentar o <select> do form
        List<Proprietario> proprietarios = db.query(
                "select * from proprietario",
                (res, rowNum) -> {
                    Proprietario proprietario = new Proprietario(
                            res.getInt("id"),
                            res.getString("nome"),
                            res.getString("telefone"));
                    return proprietario;
                });
        model.addAttribute("proprietario", proprietarios);
        // fim do trecho
        return "cad_apto";
    }

    @PostMapping("/novo_prop")
    public String gravaDados(Proprietario proprietario) {
        db.update("insert into proprietario(nome, telefone) values (?, ?)",
                proprietario.getNome(), proprietario.getTelefone());
        return "home";
    }

    @PostMapping("/novo_apto")
    public String gravaDadosApto(Apartamento apartamento) {
        db.update("insert into proprietario(nroPorta, quartos, proprietario_id, tipo) values (?, ?, ?, ?)",
                apartamento.getNroPorta(), apartamento.getQuartos(), apartamento.getProprietario().getId());
        return "home";
    }
    

}
