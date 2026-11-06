import java.util.Calendar; 
import java.util.GregorianCalendar; 

public class Docente extends Socio{
    private String area; 
    
    public Docente(int p_dniSocio, String p_nombre, int p_diasPrestamo, String p_area){
        super(p_dniSocio, p_nombre, p_diasPrestamo);
        this.setArea(p_area);
    }
    
    private void setArea(String p_area){
        area = p_area;
    }
    
    public String getArea(){
        return area;
    }
  
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
    
    
    public void cambiarDiasDePrestamo(int p_dias){
        this.setDiasPrestamo(this.getDiasPrestamo() + p_dias);
    }
    
    //@No esta especificado en las consignas si deberia ir un Override en este como si lo esta en Estudiante, asi que se queda asi por el momento 
    public boolean puedePedir(){
        return super.puedePedir();        
    }
    
    public String soyDeLaClase(){
        return "Docente";
    }
}
