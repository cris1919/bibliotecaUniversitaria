package com.biblioteca.models;

import jakarta.persistence.*;
@Entity
@Table(name = "ejemplar")

public class Ejemplar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ejemplar")
    private Integer idEjemplar;

    @Column(name = "codigo_barras", nullable = false, unique = true, length = 30)
    private String codigoBarras;

    @Column(name = "estado", nullable = false, length = 20)
    private String estado = "DISPONIBLE";

    @ManyToOne
    @JoinColumn(name = "id_libro", nullable = false)
    private Libro libro;

    public Ejemplar() {
    }

    public Ejemplar(String codigoBarras, String estado, Libro libro) {
        this.codigoBarras = codigoBarras;
        this.estado = estado;
        this.libro = libro;
    }

    public boolean estaDisponible() {
        return "DISPONIBLE".equals(estado);
    }

    public Integer getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar(Integer idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
}
