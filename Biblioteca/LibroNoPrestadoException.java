/**
 * 
 * @author Jeremias Fernandez Zalazar. 
 * @version 1.0
 */

public class LibroNoPrestadoException extends Exception {
  LibroNoPrestadoException(Libro p_libro) {
    super("El libro "+ p_libro.getTitulo() +" ya que se encuentra en la biblioteca");
  }
}
