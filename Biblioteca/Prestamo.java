package biblioteca;

import java.util.Calendar;

public class Prestamo
{
    private Calendar fechaRetiro;
    private Calendar fechaDevolucion;
    private Socio socio;
    private Libro libro;
    
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
    
    public Calendar getFechaRetiro(){
        return this.fechaRetiro;
    }
    
    public Calendar getFechaDevolucion(){
        return this.fechaDevolucion;
    }
    
    public Socio getSocio(){
        return this.socio;
    }
    
    public Libro getLibro(){
        return this.libro;
    }
    
    public void registrarFechaDevolucion(Calendar p_fecha){
        this.setFechaDevolucion(p_fecha);
    }
    
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
