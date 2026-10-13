package com.biblioteca.controllers;

import com.biblioteca.models.Bibliotecario;
import com.biblioteca.repository.BibliotecarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.List;

@Controller
public class BibliotecarioController {

    @Autowired
    private BibliotecarioRepository bibliotecarioRepository;

    @GetMapping("/bibliotecarios")
    public String listarBibliotecarios(Model model) {
        List<Bibliotecario> lista = bibliotecarioRepository.findAll();
        model.addAttribute("bibliotecarios", lista);
        model.addAttribute("nuevoBibliotecario", new Bibliotecario());
        return "bibliotecarios";
    }

    @PostMapping("/bibliotecarios/guardar")
    public String guardarBibliotecario(@ModelAttribute Bibliotecario bibliotecario) {
        bibliotecarioRepository.save(bibliotecario);
        return "redirect:/bibliotecarios";
    }
}
