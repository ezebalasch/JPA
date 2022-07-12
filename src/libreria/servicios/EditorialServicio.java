/*
// Curso Egg FullStack
 */
package libreria.servicios;

import libreria.entidades.Editorial;
import libreria.persistencia.EditorialDAO;

/**
 *
 * @author Ezequiel Balasch
 */
public class EditorialServicio {
    private AutorServicio autorServicio;
    private LibroServicio libroServicio;
    private final EditorialDAO DAO;

    public EditorialServicio() {
        this.DAO = new EditorialDAO();
    }

    public void setServicio(AutorServicio autorServicio, LibroServicio libroServicio) {
        this.autorServicio = autorServicio;
        this.libroServicio = libroServicio;
    }
    
    public Editorial crearEditorial(Integer Id, String nombre, Boolean alta){
        Editorial editorial = new Editorial();
        try {
            editorial.setId(Id);
            editorial.setNombre(nombre);
            editorial.setAlta(alta);
            
            DAO.guardar(editorial);
            return editorial;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Editorial editarEditorial(Integer Id, String nombre){
        Editorial editorial = new Editorial();
        try {
            editorial = DAO.buscarPorId(Id);
            editorial.setNombre(nombre);
            
            DAO.editar(editorial);
            return editorial;            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public Boolean eliminarEditorial(Integer id){
        try {
            DAO.eliminar(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
        public Editorial buscarPorId(Integer id){
        try {
            return DAO.buscarPorId(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    
}
