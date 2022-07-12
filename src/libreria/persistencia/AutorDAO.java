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

    @Override
    public void editar(Autor autor) {
        conectar();
        super.editar(autor);
        desconectar();
    }

    public void eliminar(Integer id) {
        Autor autor = buscarPorId(id);
        super.eliminar(autor);
    }

    public Autor buscarPorNombre(String nombre) {
        conectar();
        Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre")
                .setParameter("nombre", nombre).getSingleResult();
        desconectar();
        return autor;
    }

    public Autor buscarPorId(Integer id) {
        conectar();
        Autor autor = em.find(Autor.class, id);
        desconectar();
        return autor;
    }
}
