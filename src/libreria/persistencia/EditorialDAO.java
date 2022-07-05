/*
// Curso Egg FullStack
 */
package libreria.persistencia;

import libreria.entidades.Editorial;

/**
 *
 * @author Ezequiel Balasch
 */
public class EditorialDAO extends DAO<Editorial> {

    @Override
    public void guardar(Editorial editorial) {
        super.guardar(editorial);
    }

    public Editorial buscarPorNombre(String nombre) {
        conectar();
        Editorial editorial = (Editorial) em.createQuery("SELECT e FROM editorial e WHERE e.nombre LIKE :nombre")
                .setParameter("nombre", nombre).getSingleResult();
        desconectar();
        return editorial;
    }

    public void editar(Integer id) {
        conectar();
        Editorial editorial = buscarPorId(id);
        super.editar(editorial);
        desconectar();
    }

    public void eliminar(String nombre) {
        Editorial editorial = buscarPorNombre(nombre);
        super.eliminar(editorial);
    }

    public Editorial buscarPorId(Integer id) {
        conectar();
        Editorial editorial = em.find(Editorial.class, id);
        desconectar();
        return editorial;
    }

}
