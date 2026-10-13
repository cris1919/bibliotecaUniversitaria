package com.biblioteca.controllers;

import com.biblioteca.models.Ejemplar;
import com.biblioteca.repository.EjemplarRepository;
import com.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.List;

@Controller
public class EjemplarController {

    @Autowired
    private EjemplarRepository ejemplarRepository;

    @Autowired
    private LibroRepository libroRepository;

    @GetMapping("/ejemplares")
    public String listarEjemplares(Model model) {
        List<Ejemplar> lista = ejemplarRepository.findAll();
        model.addAttribute("ejemplares", lista);
        model.addAttribute("libros", libroRepository.findAll());
        model.addAttribute("nuevoEjemplar", new Ejemplar());
        return "ejemplares";
    }

    @PostMapping("/ejemplares/guardar")
    public String guardarEjemplar(@ModelAttribute Ejemplar ejemplar) {
        ejemplarRepository.save(ejemplar);
        return "redirect:/ejemplares";
    }
}
