package biblioteca;
/**
 * Excepción personalizada que se lanza cuando se intenta realizar
 * una operación con un libro que no se encuentra prestado.
 * 
 * @author Jeremias Fernandez Zalazar.
 * @version 1.0
 */

public class LibroNoPrestadoException extends Exception {
  public LibroNoPrestadoException(String mensaje) {
        super(mensaje);
    }
}
