/*
// Curso Egg FullStack
 */
package libreria;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public void ejecucion() throws Exception {
        try {
            int decision = 0;
            int salida = 1;
            int incisos = 0;
            while (salida == 1) {
                menuDesplegable();
                decision = leer.nextInt();
                if (decision >= 1 && decision <= 3) {
                    incisosDeMenu();
                    incisos = leer.nextInt();
                    while (salida == 1 && decision >= 1 && decision <= 4 ) {
                        if (decision == 1) {
                            switch (incisos) {
                                case 0:
                                    salida = 0;
                                    break;
                                case 1:

                                    menuDesplegable();
                                    decision = leer.nextInt();
                                    break;
                                case 2:

                                    menuDesplegable();
                                    decision = leer.nextInt();
                                    break;
                                case 3:

                                    menuDesplegable();
                                    decision = leer.nextInt();
                                    break;
                                case 4:

                                    menuDesplegable();
                                    decision = leer.nextInt();
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

                                    menuDesplegable();
                                    decision = leer.nextInt();
                                    break;
                                case 2:

                                    menuDesplegable();
                                    decision = leer.nextInt();
                                    break;
                                case 3:

                                    menuDesplegable();
                                    decision = leer.nextInt();
                                    break;
                                case 4:

                                    menuDesplegable();
                                    decision = leer.nextInt();
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

                                    menuDesplegable();
                                    decision = leer.nextInt();
                                    break;
                                case 2:

                                    menuDesplegable();
                                    decision = leer.nextInt();
                                    break;
                                case 3:

                                    menuDesplegable();
                                    decision = leer.nextInt();
                                    break;
                                case 4:

                                    menuDesplegable();
                                    decision = leer.nextInt();
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

                                    menuDesplegable();
                                    decision = leer.nextInt();
                                    break;
                                case 2:

                                    menuDesplegable();
                                    decision = leer.nextInt();
                                    break;
                                case 3:

                                    menuDesplegable();
                                    decision = leer.nextInt();
                                    break;
                                case 4:

                                    menuDesplegable();
                                    decision = leer.nextInt();
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
                            
                            break;
                        case 5:
                            
                            break;
                        case 6:
                            
                            break;
                        case 7:
                            
                            break;
                        case 8:
                            
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
        System.out.println("0_SALIDA");
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

}
