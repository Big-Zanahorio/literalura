package com.alura.literalura.repository;

import com.alura.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Query("SELECT a FROM Autor a " +
            "WHERE a.fechaNacimiento <= :anio " +
            "AND (a.fechaDefuncion IS NULL OR a.fechaDefuncion >= :anio)")
    List<Autor> autoresPorFecha(int anio);
}
