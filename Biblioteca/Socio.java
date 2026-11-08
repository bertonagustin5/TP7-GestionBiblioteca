package biblioteca;

import java.util.Calendar;
import java.util.*;

/**
 * Clase abstracta que representa a un socio genérico de la biblioteca.
 * Define los atributos y comportamientos base para cualquier tipo de socio,
 * incluyendo la gestión de sus préstamos activos y su historial.
 * 
 * @author Agustin Berton
 * @version 1.0
 */
public abstract class Socio
{
    private int dniSocio;
    private String nombre;
    private int diasPrestamo;
    private ArrayList<Prestamo> prestamos;
    
    /**
     * Constructor para inicializar un socio con una lista de préstamos vacía.
     * 
     * @param p_dniSocio     El número de DNI del socio.
     * @param p_nombre       El nombre y apellido del socio.
     * @param p_diasPrestamo La cantidad de días base que el socio tiene permitido retener un libro.
     */
    public Socio(int p_dniSocio, String p_nombre, int p_diasPrestamo){
        this.setDniSocio(p_dniSocio);
        this.setNombre(p_nombre);
        this.setDiasPrestamo(p_diasPrestamo);
        this.setPrestamos(new ArrayList<Prestamo>());
    }
    
    /**
     * Constructor sobrecargado para inicializar un socio con una lista de préstamos preexistente.
     * 
     * @param p_dniSocio     El número de DNI del socio.
     * @param p_nombre       El nombre y apellido del socio.
     * @param p_diasPrestamo La cantidad de días base que el socio tiene permitido retener un libro.
     * @param p_prestamos    Colección de préstamos asociados previamente al socio.
     */
    public Socio(int p_dniSocio, String p_nombre, int p_diasPrestamo, ArrayList<Prestamo> p_prestamos) {
        this.setDniSocio(p_dniSocio);
        this.setNombre(p_nombre);
        this.setDiasPrestamo(p_diasPrestamo);
        this.setPrestamos(p_prestamos);
    }
    
    private void setDniSocio(int p_dniSocio){
        this.dniSocio = p_dniSocio;
    }
    
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    
    protected void setDiasPrestamo(int p_diasPrestamo){
        this.diasPrestamo = p_diasPrestamo;
    }
    
    private void setPrestamos(ArrayList<Prestamo> p_prestamos){
        this.prestamos = p_prestamos;
    }
    
    /**
     * Obtiene el DNI del socio.
     * 
     * @return DNI del socio como entero.
     */
    public int getDniSocio(){
        return this.dniSocio;
    }
    
    /**
     * Obtiene el nombre del socio.
     * 
     * @return Cadena de texto con el nombre del socio.
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * Obtiene la cantidad de días que el socio tiene permitidos por préstamo.
     * 
     * @return Días de préstamo como entero.
     */
    public int getDiasPrestamo(){
        return this.diasPrestamo;
    }

    /**
     * Obtiene el historial completo de préstamos del socio.
     * 
     * @return Colección de objetos Prestamo.
     */
    public ArrayList<Prestamo> getPrestamos(){
        return this.prestamos;
    }

    /**
     * Agrega un nuevo préstamo a la lista del socio, validando que el préstamo 
     * sea válido y no esté duplicado o ya devuelto.
     * 
     * @param p_prestamo Objeto Prestamo a vincular con el socio.
     * @return true si el préstamo se agregó con éxito, false en caso contrario.
     */
    public boolean agregarPrestamo(Prestamo p_prestamo) {
       if (p_prestamo == null || p_prestamo.getSocio() != this ||
        p_prestamo.getLibro() == null ||
        p_prestamo.getFechaDevolucion() != null) {
        return false;
        }
    
        for (Prestamo unPrestamo : this.getPrestamos()) {
            if (unPrestamo.getLibro() == p_prestamo.getLibro()) {
                return false;
            }
        }
        
        return this.getPrestamos().add(p_prestamo);
    }

    /**
     * Quita un préstamo específico de la lista del socio.
     * 
     * @param p_prestamo El préstamo que se desea remover.
     * @return true si se removió con éxito, false si el préstamo no era válido o ya estaba devuelto.
     */
    public boolean quitarPrestamo(Prestamo p_prestamo) {
        if (p_prestamo == null || p_prestamo.getSocio() != this ||
            p_prestamo.getFechaDevolucion() == null) {
            return false;
        }

        return this.getPrestamos().remove(p_prestamo);
    }

    /**
     * Calcula la cantidad de libros que el socio tiene actualmente en su poder 
     * (préstamos que aún no tienen fecha de devolución).
     * 
     * @return Cantidad de libros prestados activos.
     */
    public int cantLibrosPrestados(){
        int cantidad = 0;
        
        for(Prestamo prestamo: this.getPrestamos()){
            if(prestamo.getFechaDevolucion() == null){
                cantidad = cantidad + 1;
            }
        }
        
        return cantidad;
    }

    /**
     * Genera una representación en formato de texto con los datos principales del socio.
     * 
     * @return String con formato "D.N.I. : <dni> || <nombre> (<tipo>) || Libros prestados: <cant>"
     */
    public String toString(){
        return "D.N.I. : " + this.getDniSocio() + " || " + this.getNombre() + " (" + this.soyDeLaClase() + ") || Libros prestados: " + this.cantLibrosPrestados();
    }

    /**
     * Verifica si el socio cumple con los requisitos generales para solicitar un nuevo préstamo.
     * La regla general para todos los socios es no tener ningún préstamo vencido.
     * 
     * @return true si el socio está habilitado para pedir un libro, false si tiene deuda pendiente.
     */
    public boolean puedePedir(){
        Calendar fechaHoy = new GregorianCalendar();

        for (Prestamo unPrestamo : this.getPrestamos()) {
            if (unPrestamo.getFechaDevolucion() == null && unPrestamo.vencido(fechaHoy)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Método abstracto que debe ser implementado por las subclases para identificar 
     * el tipo de socio (ej. "Estudiante" o "Docente").
     * 
     * @return Cadena de texto que identifica el rol del socio.
     */
    public abstract String soyDeLaClase();
}
