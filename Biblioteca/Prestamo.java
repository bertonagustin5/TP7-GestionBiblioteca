package biblioteca;

import java.util.Calendar;

/**
 * Clase que representa el préstamo de un libro a un socio de la biblioteca.
 * Almacena las fechas de retiro y devolución, y vincula las instancias de Libro y Socio.
 * 
 * @author Agustin Berton
 * @version 1.0
 */
public class Prestamo
{
    private Calendar fechaRetiro;
    private Calendar fechaDevolucion;
    private Socio socio;
    private Libro libro;

    /**
     * Constructor para inicializar un nuevo préstamo.
     * La fecha de devolución se establece inicialmente en null, indicando que el préstamo está activo.
     * 
     * @param p_fechaRetiro La fecha en la que se efectúa el préstamo.
     * @param p_socio       El socio que solicita el libro.
     * @param p_libro       El libro que es prestado.
     */
    public Prestamo(Calendar p_fechaRetiro, Socio p_socio, Libro p_libro){
        this.setFechaRetiro(p_fechaRetiro);
        this.setFechaDevolucion(null);
        this.setSocio(p_socio);
        this.setLibro(p_libro);
    }
    
    private void setFechaRetiro(Calendar p_fechaRetiro){
        this.fechaRetiro = p_fechaRetiro;
    }
    
    private void setFechaDevolucion(Calendar p_fechaDevolucion){
        this.fechaDevolucion = p_fechaDevolucion;
    }
    
    private void setSocio(Socio p_socio){
        this.socio = p_socio;
    }
    
    private void setLibro(Libro p_libro){
        this.libro = p_libro;
    }

    /**
     * Obtiene la fecha en la que se retiró el libro.
     * 
     * @return Objeto Calendar con la fecha de retiro.
     */
    public Calendar getFechaRetiro(){
        return this.fechaRetiro;
    }

    /**
     * Obtiene la fecha en la que el libro fue devuelto a la biblioteca.
     * 
     * @return Objeto Calendar con la fecha de devolución, o null si aún no fue devuelto.
     */
    public Calendar getFechaDevolucion(){
        return this.fechaDevolucion;
    }

    /**
     * Obtiene el socio asociado a este préstamo.
     * 
     * @return Objeto Socio que retiró el libro.
     */
    public Socio getSocio(){
        return this.socio;
    }

    /**
     * Obtiene el libro asociado a este préstamo.
     * 
     * @return Objeto Libro prestado.
     */
    public Libro getLibro(){
        return this.libro;
    }

    /**
     * Registra la fecha de devolución del libro, cerrando el ciclo del préstamo.
     * 
     * @param p_fecha Objeto Calendar que representa el momento exacto de la devolución.
     */
    public void registrarFechaDevolucion(Calendar p_fecha){
        this.setFechaDevolucion(p_fecha);
    }

    /**
     * Evalúa si el préstamo se encuentra vencido respecto a una fecha de control.
     * El cálculo se realiza sumando los días de préstamo permitidos por el socio 
     * a la fecha de retiro original.
     * 
     * @param p_fecha La fecha contra la cual se va a comparar (generalmente la fecha actual).
     * @return true si la fecha pasada como parámetro superó la fecha de vencimiento, false en caso contrario.
     */
    public boolean vencido(Calendar p_fecha){
        Calendar fechaVencimiento = (Calendar) this.getFechaRetiro().clone();

        fechaVencimiento.add(Calendar.DAY_OF_MONTH, this.getSocio().getDiasPrestamo());

        if (p_fecha.get(Calendar.YEAR) > fechaVencimiento.get(Calendar.YEAR)) {
            return true;
        }

        if (p_fecha.get(Calendar.YEAR) == fechaVencimiento.get(Calendar.YEAR)
            && p_fecha.get(Calendar.DAY_OF_YEAR) > fechaVencimiento.get(Calendar.DAY_OF_YEAR)) {
            return true;
        }

        return false; 
    }

    /**
     * Genera una cadena de texto formateada con los detalles principales del préstamo,
     * incluyendo fechas (año/mes/día), título del libro y nombre del socio.
     * Si no tiene fecha de devolución, indica "Pendiente".
     * 
     * @return String detallando el estado actual del préstamo.
     */
    public String toString(){
        Calendar retiro = this.getFechaRetiro();

        String fechaRetiro = retiro.get(Calendar.YEAR) + "/" + (retiro.get(Calendar.MONTH) + 1) + "/" + retiro.get(Calendar.DAY_OF_MONTH);
    
        String fechaDevolucion = "Pendiente";
    
        if (this.getFechaDevolucion() != null) {
            Calendar devolucion = this.getFechaDevolucion();
    
            fechaDevolucion = devolucion.get(Calendar.YEAR) + "/" + (devolucion.get(Calendar.MONTH) + 1) + "/" + devolucion.get(Calendar.DAY_OF_MONTH);
        }
    
        return "Retiro: " + fechaRetiro + " - Devolución: " + fechaDevolucion + "\nLibro: " + this.getLibro().getTitulo() + "\nSocio: " + this.getSocio().getNombre();
    }
}
