/*
// Curso Egg FullStack
 */
package libreria.persistencia;

import libreria.entidades.Autor;

/**
 *
 * @author Ezequiel Balasch
 */
public class AutorDAO extends DAO<Autor> {

    @Override
    public void guardar(Autor autor) {
        super.guardar(autor);
    }

    public Autor buscarPorNombre(String nombre) {
        conectar();
        Autor autor = (Autor) em.createQuery("SELECT a FROM autor a WHERE a.nombre LIKE :nombre")
                .setParameter("nombre", nombre).getSingleResult();
        desconectar();
        return autor;
    }

    public void editar(Integer id) {
        conectar();
        Autor autor = buscarPorId(id);
        super.editar(autor);
        desconectar();
    }

    public void eliminar(String nombre) {
        Autor autor = buscarPorNombre(nombre);
        super.eliminar(autor);
    }

    public Autor buscarPorId(Integer id) {
        conectar();
        Autor autor = em.find(Autor.class, id);
        desconectar();
        return autor;
    }
}
