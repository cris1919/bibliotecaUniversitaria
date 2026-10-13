package com.biblioteca.controllers;

import com.biblioteca.models.Prestamo;
import com.biblioteca.repository.BibliotecarioRepository;
import com.biblioteca.repository.EjemplarRepository;
import com.biblioteca.repository.PrestamoRepository;
import com.biblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.List;

@Controller
public class PrestamoController {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EjemplarRepository ejemplarRepository;

    @Autowired
    private BibliotecarioRepository bibliotecarioRepository;

    @GetMapping("/prestamos")
    public String listarPrestamos(Model model) {
        List<Prestamo> lista = prestamoRepository.findAll();
        model.addAttribute("prestamos", lista);
        model.addAttribute("usuarios", usuarioRepository.findAll());
        model.addAttribute("ejemplares", ejemplarRepository.findAll());
        model.addAttribute("bibliotecarios", bibliotecarioRepository.findAll());
        model.addAttribute("nuevoPrestamo", new Prestamo());
        return "prestamos";
    }

    @PostMapping("/prestamos/guardar")
    public String guardarPrestamo(@ModelAttribute Prestamo prestamo) {
        prestamoRepository.save(prestamo);
        return "redirect:/prestamos";
    }
}
