package com.alura.literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int fechaNacimiento;
    private int fechaDefuncion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(int fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getFechaDefuncion() {
        return fechaDefuncion;
    }

    public void setFechaDefuncion(int fechaDefuncion) {
        this.fechaDefuncion = fechaDefuncion;
    }

    public Autor() {
    }

    public Autor(DatosAutor datosAutor) {
        this.name = datosAutor.name();
        this.fechaNacimiento = datosAutor.birth_year();
        this.fechaDefuncion = datosAutor.death_year();
    }

    @Override
    public String toString(){
        return
                "Name: " + name + "\n" +
                "Birth year: " + fechaNacimiento + "\n" +
                "Death year: " + fechaDefuncion + "\n";
    }

}
