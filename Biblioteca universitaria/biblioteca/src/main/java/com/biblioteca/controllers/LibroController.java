package com.biblioteca.controllers;

import com.biblioteca.models.Libro;
import com.biblioteca.repository.AutorRepository;
import com.biblioteca.repository.CategoriaRepository;
import com.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class LibroController {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping("/libros")
    public String listarLibros(Model model) {
        List<Libro> lista = libroRepository.findAll();
        model.addAttribute("libros", lista);
        model.addAttribute("categorias", categoriaRepository.findAll());
        model.addAttribute("autores", autorRepository.findAll());
        model.addAttribute("nuevoLibro", new Libro());
        return "libros";
    }

    @PostMapping("/libros/guardar")
    public String guardarLibro(@ModelAttribute Libro libro,
                               @RequestParam(name = "autoresIds", required = false) List<Integer> autoresIds) {
        if (autoresIds != null) {
            libro.setAutores(autorRepository.findAllById(autoresIds));
        }
        libroRepository.save(libro);
        return "redirect:/libros";
    }
}
