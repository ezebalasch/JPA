/*
// Curso Egg FullStack
 */
package libreria.servicios;

import java.util.List;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.persistencia.LibroDAO;

/**
 *
 * @author Ezequiel Balasch
 */
public class LibroServicio {

    private EditorialServicio editorialservicio;
    private AutorServicio autorservicio;
    private final LibroDAO DAO;

    public LibroServicio() {
        this.DAO = new LibroDAO();
    }

    public void setServicio(EditorialServicio editorialservicio, AutorServicio autorservicio) {
        this.editorialservicio = editorialservicio;
        this.autorservicio = autorservicio;
    }

    public Libro crearLibro(Long isbn, String titulo, Integer anio, Integer ejemplares,
            Integer ejemplaresPrestados, Integer ejemplaresRestantes, Boolean alta,
            Autor autor, Editorial editorial) {
        Libro libro = new Libro();
        try {
            libro.setIsbn(isbn);
            libro.setTitulo(titulo);
            libro.setAnio(anio);
            libro.setEjemplares(ejemplares);
            libro.setEjemplaresPrestados(ejemplaresPrestados);
            libro.setEjemplaresRestantes(ejemplaresRestantes);
            libro.setAlta(alta);
            libro.setAutor(autor);
            libro.setEditorial(editorial);

            DAO.guardar(libro);
            return libro;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Libro editarLibro(Long isbn, String titulo, Integer anio, Integer ejemplares,
            Integer ejemplaresPrestados, Integer ejemplaresRestantes, Boolean alta,
            Autor autor, Editorial editorial) {
        Libro libro = new Libro();
        try {
            libro = DAO.buscarPorIsbn(isbn);
            libro.setTitulo(titulo);
            libro.setAnio(anio);
            libro.setEjemplares(ejemplares);
            libro.setEjemplaresPrestados(ejemplaresPrestados);
            libro.setEjemplaresRestantes(ejemplaresRestantes);
            libro.setAlta(alta);
            libro.setAutor(autor);
            libro.setEditorial(editorial);

            DAO.editar(libro);
            return libro;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Boolean eliminarPorIsbn(Long isbn) {
        try {
            DAO.eliminar(isbn);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Libro busquedaIsbn(Long isbn) {
        try {
            return DAO.buscarPorIsbn(isbn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Libro busquedaNombre(String nombre) {
        try {
            return DAO.buscarPorNombre(nombre);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Libro> busquedaAutor(String autor) {
        try {
            return DAO.buscarPorNombreAutor(autor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Libro> busquedaEditorial(String editorial) {
        try {
            return DAO.buscarPorNombreEditorial(editorial);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
