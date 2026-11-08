package biblioteca;
import java.util.Calendar; 
import java.util.GregorianCalendar; 

/**
 * Representa a un socio de la biblioteca que es docente.
 * Hereda el comportamiento general de {@link Socio} y agrega el área
 * en la que se desempeña, además de poder consultar si es responsable
 * con sus devoluciones y modificar sus días de préstamo.
 */
public class Docente extends Socio{
     /** Área en la que se desempeña el docente. */
    private String area; 
    
    /**
     * Crea un docente con sus datos personales y su área.
     *
     * @param p_dniSocio     DNI del docente.
     * @param p_nombre       nombre del docente.
     * @param p_diasPrestamo cantidad de días que dura un préstamo.
     * @param p_area         área en la que se desempeña el docente.
     */
    
    public Docente(int p_dniSocio, String p_nombre, int p_diasPrestamo, String p_area){
        super(p_dniSocio, p_nombre, p_diasPrestamo);
        this.setArea(p_area);
    }
    
    /**
     * Establece el área del docente.
     *
     * @param p_area área en la que se desempeña el docente.
     */
    private void setArea(String p_area){
        area = p_area;
    }
    
    /**
     * Devuelve el área del docente.
     *
     * @return el área en la que se desempeña el docente.
     */
    public String getArea(){
        return area;
    }
    
   /**
     * Indica si el docente es responsable con sus préstamos.
     * Recorre todos sus préstamos y controla si alguno estuvo vencido:
     * si el préstamo ya fue devuelto se compara contra la fecha de
     * devolución; si sigue pendiente, contra la fecha actual.
     *
     * @return {@code true} si ningún préstamo está o estuvo vencido;
     *         {@code false} si tiene al menos uno vencido.
     */
    public boolean esResponsable(){
      Calendar hoy = new GregorianCalendar();
     
        for(Prestamo unPrestamo : this.getPrestamos()){
            Calendar fechaControl;
            if (unPrestamo.getFechaDevolucion() == null){
                fechaControl = hoy; 
            } else {
                 fechaControl = unPrestamo.getFechaDevolucion();
            }
            
            if(unPrestamo.vencido(fechaControl)){
                return false;
            }
        }
          return true;
     
    }
    
     /**
     * Modifica los días de préstamo del docente sumando la cantidad indicada
     * a los días actuales.
     *
     * @param p_dias cantidad de días a sumar (puede ser negativa para restar).
     */
    public void cambiarDiasDePrestamo(int p_dias){
        this.setDiasPrestamo(this.getDiasPrestamo() + p_dias);
    }
    
     /**
     * Indica si el docente puede pedir un nuevo libro prestado.
     * Utiliza las mismas condiciones generales definidas en {@link Socio}.
     *
     * @return {@code true} si cumple las condiciones del socio;
     *         {@code false} en caso contrario.
     */
    //@No esta especificado en las consignas si deberia ir un Override en este como si lo esta en Estudiante, asi que se queda asi por el momento
    public boolean puedePedir(){
        return super.puedePedir();        
    }

    /**
     * Devuelve el nombre de la clase a la que pertenece el socio.
     *
     * @return la cadena "Docente".
     */
    public String soyDeLaClase(){
        return "Docente";
    }
}
