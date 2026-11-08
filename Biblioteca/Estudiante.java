package biblioteca;

/**
 * Representa a un socio de la biblioteca que es estudiante.
 * Hereda el comportamiento general de {@link Socio} y agrega la carrera
 * que cursa, además de una restricción propia sobre la cantidad de
 * libros que puede tener prestados.
 */

public class Estudiante extends Socio{
    
  /** Carrera que cursa el estudiante. */
    private String carrera; 
    
  /**
     * Crea un estudiante con sus datos personales y su carrera.
     *
     * @param p_dniSocio     DNI del estudiante.
     * @param p_nombre       nombre del estudiante.
     * @param p_diasPrestamo cantidad de días que dura un préstamo.
     * @param p_carrera      carrera que cursa el estudiante.
     */
   public Estudiante(int p_dniSocio, String p_nombre, int p_diasPrestamo,String p_carrera){
    super(p_dniSocio, p_nombre, p_diasPrestamo);
    this.setCarrera(p_carrera);
   }

     /**
     * Establece la carrera del estudiante.
     *
     * @param p_carrera carrera que cursa el estudiante.
     */
   private void setCarrera(String p_carrera){
       carrera = p_carrera;
   }


    /**
     * Devuelve la carrera del estudiante.
     *
     * @return la carrera que cursa el estudiante.
     */
   public String getCarrera(){
       return carrera; 
   }
   
   
 /**
     * Indica si el estudiante puede pedir un nuevo libro prestado.
     * Además de cumplir las condiciones generales de {@link Socio},
     * un estudiante no puede tener 3 o más libros prestados a la vez.
     *
     * @return {@code true} si cumple las condiciones del socio y tiene
     *         menos de 3 libros prestados; {@code false} en caso contrario.
     */
    //@Override
   public boolean puedePedir(){
       return super.puedePedir() && this.cantLibrosPrestados() < 3;
   }
   

    /**
     * Devuelve el nombre de la clase a la que pertenece el socio.
     *
     * @return la cadena "Estudiante".
     */
  public String soyDeLaClase(){
       return "Estudiante";
    }
   
}
