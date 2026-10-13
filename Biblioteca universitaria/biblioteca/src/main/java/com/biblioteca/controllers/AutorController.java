package com.biblioteca.controllers;

import com.biblioteca.models.Autor;
import com.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.List;

@Controller
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping("/autores")
    public String listarAutores(Model model) {
        List<Autor> lista = autorRepository.findAll();
        model.addAttribute("autores", lista);
        model.addAttribute("nuevoAutor", new Autor());
        return "autores";
    }

    @PostMapping("/autores/guardar")
    public String guardarAutor(@ModelAttribute Autor autor) {
        autorRepository.save(autor);
        return "redirect:/autores";
    }
}
