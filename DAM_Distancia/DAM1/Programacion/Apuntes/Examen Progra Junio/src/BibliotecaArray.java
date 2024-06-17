/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

/**
 *
 * @author xdGHOSTbx
 */
public class BibliotecaArray {
    private Libro[] libros; // Array para almacenar libros
    private int cantidadLibros; // Contador de libros en la biblioteca

    // Constructor para inicializar el array de libros
    public BibliotecaArray(int capacidadMaxima) {
        libros = new Libro[capacidadMaxima];
        cantidadLibros = 0;
    }

    // Método para agregar un libro a la biblioteca
    public void agregarLibro(Libro libro) {
        if (cantidadLibros < libros.length) {
            libros[cantidadLibros] = libro;
            cantidadLibros++;
        } else {
            System.out.println("La biblioteca está llena");
        }
    }

    // Método para buscar un libro por su isbn
    public String buscarLibroPorISBN(int isbn) {
        String datos = null;
        boolean encontrado = false;
        for (int i = 0; i < cantidadLibros; i++) {
            if (libros[i].getISBN() == isbn ) {
                datos = libros[i-1].verLibro()+"\n"+libros[i+1].verLibro(); 
                encontrado = true;
                break;
            }
            
            if (!encontrado){
              datos = libros[cantidadLibros-1].verLibro();
            }
        }
        return datos;
    }
}
