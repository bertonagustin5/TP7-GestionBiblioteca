package biblioteca;
/**
 * 
 * @author Jeremias Fernandez Zalazar. 
 * @version 1.0
 */

public class LibroNoPrestadoException extends Exception {
  public LibroNoPrestadoException(String mensaje) {
        super(mensaje);
    }
}
