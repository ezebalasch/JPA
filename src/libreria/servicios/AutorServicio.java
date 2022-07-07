/*
// Curso Egg FullStack
 */
package libreria.servicios;

import libreria.entidades.Autor;
import libreria.persistencia.AutorDAO;

/**
 *
 * @author Ezequiel Balasch
 */
public class AutorServicio {

    private EditorialServicio editorialServicio;
    private LibroServicio libroServicio;
    private final AutorDAO DAO;

    public AutorServicio() {
        this.DAO = new AutorDAO();
    }

    public void setServicios(EditorialServicio editorialServicio, LibroServicio libroServicio) {
        this.editorialServicio = editorialServicio;
        this.libroServicio = libroServicio;
    }

    public Autor crearAutor(Integer Id, String nombre, Boolean alta) {
        Autor autor = new Autor();
        try {
            autor.setId(Id);
            autor.setNombre(nombre);
            autor.setAlta(alta);

            DAO.guardar(autor);
            return autor;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Autor buscarPorNombre(String nombre){
        try {
            return DAO.buscarPorNombre(nombre);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Autor editarAutor(Integer id, String nombre){
        Autor autor = new Autor();
        try {
            autor = DAO.buscarPorId(id);
            autor.setNombre(nombre);
            DAO.editar(autor);
            return autor;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }   
    }
    
    public Boolean eliminarPorId(Integer id){
        try {
            DAO.eliminar(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
