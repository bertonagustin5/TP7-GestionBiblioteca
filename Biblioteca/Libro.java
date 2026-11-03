
/**
 * Write a description of class Libro here.
 * 
 * @author balenzuela, tobias. 
 * @version 1
 */
  
import java.util.*;

public class Libro
{
    
    private String titulo;
    private int edicion;
    private String editorial;
    private int anio; 
    private ArrayList <Prestamo> prestamos;
    
    /**
     * Constructor for objects of class Libro
     */
    public Libro(String p_titulo, int p_edicion, String p_editorial, int p_anio)
    {
        this.setTitulo(p_titulo);
        this.setEdicion(p_edicion);
        this.setEditorial(p_editorial);
        this.setAnio(p_anio);
        
        this.setPrestamos(new ArrayList <Prestamo>());
    }
     
    // getters y setters 
    
    private void setTitulo(String p_titulo){
        this.titulo = p_titulo; 
    }
    
    public String getTitulo(){
        return this.titulo; 
    }
    
    private void setEdicion(int p_edicion) {
        this.edicion = p_edicion; 
    }
    
    public int getEdicion(){
        return this.edicion; 
    }
    
    private void setEditorial(String p_editorial){
        this.editorial = p_editorial;
    }
    
    public String getEditorial(){
        return this.editorial; 
    }
    
    private void setAnio(int p_anio){
        this.anio = p_anio; 
    }
    
    public int getAnio(){
        return this.anio; 
    }
    
    private void setPrestamos(ArrayList <Prestamo> p_prestamos){
        this.prestamos = p_prestamos; 
    }
    
    public ArrayList <Prestamo> getPrestamos(){
        return this.prestamos; 
    }
    
    /**
     * agrega un prestamo
     * @param: Prestamo 
     * @return: coleccion de prestamos
     */
    public boolean agregarPrestamo(Prestamo p_prestamo){
        return this.getPrestamos().add(p_prestamo);
    }
    
    /**
     * quita un prestamo
     * @param: Prestamo 
     * @return: coleccion de prestamos
     */
    public boolean quitarPrestamo(Prestamo p_prestamo) {
        return this.getPrestamos().remove(p_prestamo);
    }
    
    /**
     * verifica si el libro esta prestado
     * @param: -
     * @return: boolean
     */
    public boolean prestado() {
        //ultimo prestamo registrado
        Prestamo ultimo = ultimoPrestamo(); 
        
        // verfificamos si esta vacio(nunca se presto)
        if (ultimo == null){
            return false; 
        }
        
        //fecha devolucion null, sigue prestado
        return ultimo.getFechaDevolucion() == null; 
    }
    
    /**
     * devuelve el ultimo libro prestado(ult de la coleccion)
     * @param: -  
     * @return: un prestamo
     */
    public Prestamo ultimoPrestamo() {
        // verificamos que la coleccion no este vacia
        if (this.prestamos.isEmpty()){
            return null; 
        }
        
        return prestamos.get(prestamos.size() -1); 
    }
    
    /**
     * devuelve el titulo del libro
     * @param: -
     * @return: String
     */
    public String toString(){
        return "Titulo: " + this.getTitulo(); 
    }
}

