/*
// Curso Egg FullStack
 */
package libreria;

import java.util.List;
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
                    if (salida == 4) {
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
                                    Long isbn = leer.nextLong();
                                    Libro libro0 = libroServicio.busquedaIsbn(isbn);
                                    libro0 = modificadorLibro1();
                                    libroServicio.editarLibro(libro0.getIsbn(), libro0.getTitulo(),
                                            libro0.getAnio(), libro0.getEjemplares(),
                                            libro0.getEjemplaresPrestados(), libro0.getEjemplaresRestantes(),
                                            libro0.getAlta(), libro0.getAutor(), libro0.getEditorial());

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
                                //CRUD DE AUTOR

                                case 0:
                                    salida = 4;
                                    break;
                                case 1:
                                    generadorAutor();

                                    salida = 3;

                                    break;
                                case 2:
                                    System.out.println("Su autor será buscado por nombre, luego podrá"
                                            + "modificar sus datos");
                                    String nombre = leer.next();
                                    Autor autor = autorServicio.buscarPorNombre(nombre);
                                    autor = modificadorAutor();
                                    autorServicio.editarAutor(autor.getId(), autor.getNombre());

                                    salida = 3;

                                    break;
                                case 3:
                                    System.out.println("Ingrese el nombre del autor a ver");
                                    Autor autor1 = autorServicio.buscarPorNombre(leer.next());
                                    if (autor1 == null) {
                                        System.out.println("Autor no encontrado");
                                        salida = 3;

                                    } else {
                                        System.out.println(autor1.toString());
                                        salida = 3;
                                    }
                                    break;
                                case 4:
                                    System.out.println("Ingrese el id del autor a eliminar");
                                    Boolean autorDeleted = autorServicio.eliminarPorId(leer.nextInt());
                                    if (autorDeleted) {
                                        System.out.println("Autor eliminado con éxito");
                                    } else {
                                        System.out.println("Autor no detectado");
                                    }
                                    salida = 3;
                                    break;
                                default:
                                    System.out.println("Valores de inciso incorrectos");
                            }
                        } else if (decision == 3) {
                            switch (incisos) {
                                //CRUD DE Editorial

                                case 0:
                                    salida = 4;
                                    break;
                                case 1:
                                    generadorEditorial();

                                    salida = 3;

                                    break;
                                case 2:
                                    System.out.println("Su editorial será buscada por id, luego podrá"
                                            + "modificar sus datos");
                                    Integer id = leer.nextInt();
                                    Editorial editorial = editorialServicio.buscarPorId(id);
                                    editorial = modificadorEditorial();
                                    editorialServicio.editarEditorial(editorial.getId(), editorial.getNombre());

                                    salida = 3;

                                    break;
                                case 3:
                                    System.out.println("Ingrese el id de la editorial a ver");
                                    Editorial editorial1 = editorialServicio.buscarPorId(leer.nextInt());
                                    if (editorial1 == null) {
                                        System.out.println("Editorial no encontrada");
                                        salida = 3;

                                    } else {
                                        System.out.println(editorial1.toString());
                                        salida = 3;
                                    }
                                    break;
                                case 4:
                                    System.out.println("Ingrese el id de la editorial a eliminar");
                                    Boolean editorialDeleted = editorialServicio.eliminarEditorial(leer.nextInt());
                                    if (editorialDeleted) {
                                        System.out.println("Editorial eliminada con éxito");
                                    } else {
                                        System.out.println("Editorial no detectada");
                                    }
                                    salida = 3;
                                    break;
                                default:
                                    System.out.println("Valores de inciso incorrectos");
                            }
                        }
                    }
                }
                while (salida == 1) {
                    try {
                     switch (decision) {
                        case 0:
                            System.out.println("Saliendo...");
                            salida = 0;
                            break;
                        case 4:
                            System.out.println("Ingrese nombre del autor a buscar");
                            Autor autor = autorServicio.buscarPorNombre(leer.next());
                            if (autor != null) {
                                System.out.println(autor.toString());

                            } else {
                                System.out.println("Autor no encontrado");
                            }

                            salida = 4;
                            break;
                        case 5:
                            System.out.println("Ingrese isbn del libro a buscar");
                            Libro libro = libroServicio.busquedaIsbn(leer.nextLong());
                            if (libro == null) {
                                System.out.println("Libro no encontrado");

                            } else {
                                System.out.println(libro.toString());
                            }
                            salida = 4;
                            break;
                        case 6:
                            System.out.println("Ingrese Título del Libro");
                            
                            System.out.println(libroServicio.busquedaNombre(leer.next()).toString());
                            salida = 4;
                            break;
                        case 7:
                            System.out.println("Ingrese nombre del Autor del Libro");
                            System.out.println();
                            libroServicio.busquedaAutor(leer.next()).forEach((a) -> System.out.println(a.toString()));

                            salida = 4;
                            break;
                        case 8:
                            System.out.println("Ingrese nombre de la Editorial del Libro");
                            libroServicio.busquedaEditorial(leer.next()).forEach((a) -> System.out.println(a.toString()));

                            salida = 4;
                            break;
                        default:
                            System.out.println("Valores indicados incorrectos");

                    }   
                    } catch (Exception e) {
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

    public Libro modificadorLibro1() {
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
        return libro;

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

    public void generadorAutor() {
        System.out.println("Ingrese Id del autor");
        Integer idAut = leer.nextInt();
        System.out.println("Ingrese nombre del autor");
        String nombre = leer.next();
        Boolean alta = true;

        Autor autor = autorServicio.crearAutor(idAut, nombre, alta);

        System.out.println("REALIZADO...");
        System.out.println("");
    }

    public Autor modificadorAutor() {
        System.out.println("Ingrese Id del autor");
        Integer idAut = leer.nextInt();
        System.out.println("Ingrese nombre del autor");
        String nombre = leer.next();
        Boolean alta = true;

        Autor autor = autorServicio.crearAutor(idAut, nombre, alta);

        return autor;
    }

    public void generadorEditorial() {
        System.out.println("Ingrese Id de la editorial");
        Integer idEdi = leer.nextInt();
        System.out.println("Ingrese nombre de la editorial");
        String nombre = leer.next();
        Boolean alta = true;

        Editorial editorial = editorialServicio.crearEditorial(idEdi, nombre, alta);

        System.out.println("REALIZADO...");
        System.out.println("");
    }

    public Editorial modificadorEditorial() {
        System.out.println("Ingrese Id de la editorial");
        Integer idEdi = leer.nextInt();
        System.out.println("Ingrese nombre de la editorial");
        String nombre = leer.next();
        Boolean alta = true;

        Editorial editorial = editorialServicio.crearEditorial(idEdi, nombre, alta);

        return editorial;
    }

}
