/*
// Curso Egg FullStack
 */
package libreria;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.servicios.AutorServicio;
import libreria.servicios.EditorialServicio;
import libreria.servicios.LibroServicio;

/**
 *
 * @author Ezequiel Balasch
 */
public class Principal {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    private final AutorServicio autorServicio = new AutorServicio();
    private final EditorialServicio editorialServicio = new EditorialServicio();
    private final LibroServicio libroServicio = new LibroServicio();

    public Principal() {
        autorServicio.setServicios(editorialServicio, libroServicio);
        editorialServicio.setServicio(autorServicio, libroServicio);
        libroServicio.setServicio(editorialServicio, autorServicio);
    }
    ////// Cuando la salida es igual a 4 nos retorna al menu principal
    ///// Cuando la salida es igual a 0 salimos del programa
    
    public void ejecucion() throws Exception {
        try {
            int decision = 0;
            int salida = 1;
            int incisos = 0;
            while (salida == 1 || salida == 4) {
                if (salida == 0) {
                    break;
                }
                if (salida == 4) {
                    salida = 1;
                }
                menuDesplegable();
                decision = leer.nextInt();
                while (decision >= 1 && decision <= 3) {
                    if (salida == 0) {
                        break;
                    }
                    if (salida== 4){
                        break;
                    }
                    salida = 1;
                    incisosDeMenu();
                    incisos = leer.nextInt();
                    while (salida == 1 && decision >= 1 && decision <= 4) {
                        if (decision == 1) {
                            switch (incisos) {
                                //CRUD DE LIBRO

                                case 0:
                                    salida = 4;
                                    break;
                                case 1:
                                    generadorLibro();

                                    salida = 3;

                                    break;
                                case 2:
                                    System.out.println("Su libro será buscado por isbn, luego podrá"
                                            + "modificar sus datos");
                                    generadorLibro();

                                    salida = 3;

                                    break;
                                case 3:
                                    System.out.println("Ingrese el isbn del libro a ver");
                                    Libro libro = libroServicio.busquedaIsbn(leer.nextLong());
                                    if (libro == null) {
                                        System.out.println("Libro no encontrado");
                                        salida = 3;

                                    } else {
                                        System.out.println(libro.toString());
                                        salida = 3;
                                    }
                                    break;
                                case 4:
                                    System.out.println("Ingrese el isbn del libro a eliminar");
                                    Boolean libroDeleted = libroServicio.eliminarPorIsbn(leer.nextLong());
                                    if (libroDeleted) {
                                        System.out.println("Libro eliminado con éxito");
                                    } else {
                                        System.out.println("Libro no detectado");
                                    }
                                    salida = 3;
                                    break;
                                default:
                                    System.out.println("Valores de inciso incorrectos");
                            }
                        } else if (decision == 2) {
                            switch (incisos) {
                                case 0:
                                    salida = 0;
                                    break;
                                case 1:

                                    salida = 3;
                                    break;
                                case 2:

                                    salida = 3;
                                    break;
                                case 3:

                                    salida = 3;
                                    break;
                                case 4:

                                    salida = 3;
                                    break;
                                default:
                                    System.out.println("Valores de inciso incorrectos");
                            }
                        } else if (decision == 3) {
                            switch (incisos) {
                                case 0:
                                    salida = 0;
                                    break;
                                case 1:

                                    salida = 3;
                                    break;
                                case 2:

                                    salida = 3;
                                    break;
                                case 3:

                                    salida = 3;
                                    break;
                                case 4:

                                    salida = 3;
                                    break;
                                default:
                                    System.out.println("Valores de inciso incorrectos");
                            }
                        } else {
                            switch (incisos) {
                                case 0:
                                    salida = 0;
                                    break;
                                case 1:

                                    salida = 3;
                                    break;
                                case 2:

                                    salida = 3;
                                    break;
                                case 3:

                                    salida = 3;
                                    break;
                                case 4:

                                    salida = 3;
                                    break;
                                default:
                                    System.out.println("Valores de inciso incorrectos");
                            }
                        }
                    }
                }
                while (salida == 1) {
                    switch (decision) {
                        case 0:
                            System.out.println("Saliendo...");
                            salida = 0;
                            break;
                        case 4:

                            salida = 4;
                            break;
                        case 5:

                            salida = 4;
                            break;
                        case 6:

                            salida = 4;
                            break;
                        case 7:

                            salida = 4;
                            break;
                        case 8:

                            salida = 4;
                            break;
                        default:
                            System.out.println("Valores indicados incorrectos");

                    }
                }

            }

        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void incisosDeMenu() {
        System.out.println("1_Crear");
        System.out.println("2_Modificar");
        System.out.println("3_Ver");
        System.out.println("4_Eliminar");
        System.out.println("+++++++++");
        System.out.println("0_Volver al menú principal");
        System.out.println("+++++++++");
    }

    public void menuDesplegable() {
        System.out.println("MENU BIBLIOTECA ONLINE");
        System.out.println("");
        System.out.println("A continuación debe seleccionar una opción introduciendo un número");
        System.out.println("1_CRUD Libro");
        System.out.println("2_CRUD Autor");
        System.out.println("3_CRUD Editorial");
        System.out.println("......................................................");
        System.out.println("4_Búsqueda de un Autor por nombre.");
        System.out.println("5_Búsqueda de un libro por ISBN.");
        System.out.println("6_Búsqueda de un libro por Título.");
        System.out.println("7_Búsqueda de un libro/s por nombre de Autor.");
        System.out.println("8_Búsqueda de un libro/s por nombre de Editorial.");
        System.out.println("+++++++++");
        System.out.println("0_SALIDA");
        System.out.println("+++++++++");
        System.out.println("----------------------------------------------------");
    }

    public void generadorLibro() {
        System.out.println("Ingrese isbn del libro");
        Long isbn = leer.nextLong();
        System.out.println("Ingrese Título");
        String titulo = leer.next();
        System.out.println("Ingrese anio");
        Integer anio = leer.nextInt();
        System.out.println("Ingrese número de ejemplares");
        Integer ej = leer.nextInt();
        System.out.println("Ingrese número de ejemplares Prestados");
        Integer ejpres = leer.nextInt();
        System.out.println("Ingrese el número de ejemplares restantes");
        Integer ejres = leer.nextInt();
        Boolean alta = true;
        //Datos autor en un libro
        System.out.println("Ingrese Id del autor");
        Integer idAut = leer.nextInt();
        System.out.println("Ingrese nombre del autor");
        String nomAut = leer.next();
        //Datos editorial en un libro
        System.out.println("Ingrese Id de la Editorial");
        Integer idEdi = leer.nextInt();
        System.out.println("Ingrese nombre de la Editorial");
        String nomEdi = leer.next();
        Autor autor = autorServicio.crearAutor(idAut, nomAut, alta);
        Editorial editorial = editorialServicio.crearEditorial(idEdi,
                nomEdi, alta);

        Libro libro = libroServicio.crearLibro(isbn, titulo,
                anio, ej, ejpres, ejres, alta, autor, editorial);

        System.out.println("REALIZADO...");
        System.out.println("");

    }

}
