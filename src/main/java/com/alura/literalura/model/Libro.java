package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "libros")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Libro {

    @Id
    private int id;

    private String title;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "libro_id")
    private List<Autor> authors;

    private String language;

    private int download_count;

    public Libro() {
    }
    public Libro(DatosLibro datosLibro) {
        this.id = datosLibro.id();
        this.title = datosLibro.title();
        this.authors = datosLibro.authors()
                .stream()
                .map(Autor::new) // Convierte cada Autor record en AutorEntity
                .toList();
        this.language = datosLibro.languages().get(0);
        this.download_count = datosLibro.download_count();
    }

    public List<Autor> getAuthors() {
        return authors;
    }

    @Override
    public String toString(){
        String autores = authors.stream()
                .map(Autor::getName)
                .collect(Collectors.joining(", "));
        String idiomas = String.join(", ", language);
        return
                "Titulo: " + title + "\n" +
                "Autor: " + autores + "\n" +
                "Idioma: " + idiomas + "\n" +
                "Descargas: " + download_count + "\n" ;
    }
}
