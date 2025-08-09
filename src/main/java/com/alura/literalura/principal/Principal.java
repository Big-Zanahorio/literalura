package com.alura.literalura.principal;

import com.alura.literalura.model.Autor;
import com.alura.literalura.model.DatosLibro;
import com.alura.literalura.model.Libro;
import com.alura.literalura.model.RespuestaGutendex;
import com.alura.literalura.repository.AutorRepository;
import com.alura.literalura.repository.LibroRepository;
import com.alura.literalura.service.ConvierteDatos;
import com.alura.literalura.service.GutendexClient;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private final String URL_BASE = "https://gutendex.com/books?search=";
    private Scanner teclado = new Scanner(System.in);
    private GutendexClient cliente = new GutendexClient();
    private ConvierteDatos conversor = new ConvierteDatos();
    private List<Libro> libros = new LinkedList<>();
    private List<Autor> autores = new LinkedList<>();
    private LibroRepository libroRepository;
    private AutorRepository autorRepository;

    public Principal(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }


    public void muestraElMenu() {


        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar libro por titulo
                    2 - Mostrar libros
                    3 - Mostrar autores
                    4 - Autores vivos por año
                    5 - Mostrar libros por idioma
                                  
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibro();
                    break;
                case 2:
                    mostrarLibros();
                    break;
                case 3:
                    mostrarAutores();
                    break;
                case 4:
                    mostrarAutoresPorFecha();
                    break;
                case 5:
                    mostrarLibrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }



    private RespuestaGutendex getDatosLibro(){
        System.out.println("Escribe el nombre del libro que deseas buscar");
        var libroABuscar = teclado.nextLine();
        var json = cliente.obtenerDatos(URL_BASE + libroABuscar.replace(" ", "%20"));
        RespuestaGutendex respuesta = conversor.obtenerDatos(json, RespuestaGutendex.class);
        return respuesta;
    }

    public void buscarLibro() {
        RespuestaGutendex datos = getDatosLibro();
        List<Libro> resultadoLibros = datos.results()
                .stream()
                .map(Libro::new)
                .toList();
//        resultadoLibros.forEach(System.out::println);
        System.out.println("Libro encontrado:");
        System.out.println(resultadoLibros.get(0));
        libros.add(resultadoLibros.get(0));
        libroRepository.save(resultadoLibros.get(0));
        List<Autor> resultadoAutores = resultadoLibros.get(0).getAuthors();
        autores.add(resultadoAutores.get(0));

    }

    private void mostrarLibros() {
//        libros.forEach(System.out::println);
        libros = libroRepository.findAll();
        System.out.println("\nLibros:");
        libros.forEach(System.out::println);
    }

    private void mostrarAutores() {
//        autores.forEach(System.out::println);
        autores = autorRepository.findAll();
        System.out.println("\nAutores:");
        autores.forEach(System.out::println);
    }
    private void mostrarAutoresPorFecha() {
        System.out.printf("Ingresa el año: ");
        int anio = teclado.nextInt();
//        List<Autor> autoresVivos = autores.stream()
//                .filter(a -> a.getBirth_year() <= anio && a.getDeath_year() >= anio)
//                .toList();
//        autoresVivos.forEach(System.out::println);
        autores = autorRepository.autoresPorFecha(anio);
        System.out.println("\nAutores vivos en " + anio + ":");
        autores.forEach(System.out::println);
    }

    private void mostrarLibrosPorIdioma() {
        String idioma = new String();
        System.out.println("""
                Elija el idioma:
                
                1 - EN (English)
                2 - ES (Español)
                
                """);
        int eleccion = teclado.nextInt();
        switch (eleccion){
            case 1:
                idioma = "en";
                break;
            case 2:
                idioma = "es";
                break;
            default:
                System.out.println("Eleccion invalida");
                break;

        }
        libros = libroRepository.librosPorIdioma(idioma);
        System.out.println("\nLibros en " + idioma + ":");
        libros.forEach(System.out::println);

    }
}
