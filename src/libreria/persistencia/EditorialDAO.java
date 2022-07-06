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

    @Override
    public void editar(Editorial editorial) {
        conectar();
        super.editar(editorial);
        desconectar();
    }

    public void eliminar(Integer id) {
        Editorial editorial = buscarPorId(id);
        super.eliminar(editorial);
    }

    public Editorial buscarPorId(Integer id) {
        conectar();
        Editorial editorial = em.find(Editorial.class, id);
        desconectar();
        return editorial;
    }

}
