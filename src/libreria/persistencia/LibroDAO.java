/*
// Curso Egg FullStack
 */
package libreria.persistencia;

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

    public Libro buscarPorISBN(String isbn) {
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT l FROM libro l WHERE l.isbn LIKE :isbn")
                .setParameter("isbn", isbn).getSingleResult();
        desconectar();
        return libro;
    }

    public Libro buscarPorNombreAutor(String nombre) {
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT l FROM libro a, IN(l.autor) m WHERE m.nombre LIKE :nombre")
                .setParameter("nombre", nombre).getSingleResult();
        desconectar();
        return libro;
    }

    public Libro buscarPorNombreEditorial(String nombre) {
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT l FROM libro l, IN(a.editorial) m WHERE m.nombre LIKE :nombre")
                .setParameter("nombre", nombre).getSingleResult();
        desconectar();
        return libro;
    }

    public void editar(Integer id) {
        conectar();
        Libro libro = buscarPorId(id);
        super.editar(libro);
        desconectar();
    }

    public void eliminar(String nombre) {
        Libro libro = buscarPorNombre(nombre);
        super.eliminar(libro);
    }

    public Libro buscarPorNombre(String nombre) {
        conectar();
        Libro libro = em.find(Libro.class, nombre);
        desconectar();
        return libro;
    }

    public Libro buscarPorId(Integer id) {
        conectar();
        Libro libro = em.find(Libro.class, id);
        desconectar();
        return libro;
    }

}
