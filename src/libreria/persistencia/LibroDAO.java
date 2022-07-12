/*
// Curso Egg FullStack
 */
package libreria.persistencia;

import java.util.List;
import libreria.entidades.Libro;

/**
 *
 * @author Ezequiel Balasch
 */
public class LibroDAO extends DAO<Libro> {

    @Override
    public void guardar(Libro libro) {
        super.guardar(libro);
    }

    public List<Libro> buscarPorNombreAutor(String nombre) {
        conectar();
        List<Libro> libro = em.createQuery("SELECT l FROM Libro l WHERE l.autor.nombre LIKE :nombre")
                .setParameter("nombre", nombre).getResultList();
        desconectar();
        return libro;
    }

    public List<Libro> buscarPorNombreEditorial(String nombre) {
        conectar();
        List<Libro> libro = em.createQuery("SELECT l FROM Libro l WHERE l.editorial.nombre LIKE :nombre")
                .setParameter("nombre", nombre).getResultList();
        desconectar();
        return libro;
    }

    public void editar(Libro libro) {
        conectar();
        super.editar(libro);
        desconectar();
    }

    public void eliminar(Long isbn) {
        Libro libro = buscarPorIsbn(isbn);
        super.eliminar(libro);
    }

    public Libro buscarPorNombre(String titulo) {
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :titulo")
                .setParameter("titulo", titulo).getSingleResult();
        desconectar();
        return libro;
    }

    public Libro buscarPorIsbn(Long isbn) {
        conectar();
        Libro libro = em.find(Libro.class, isbn);
        desconectar();
        return libro;
    }

}
