public class Estudiante extends Socio{
    public static final int DIAS_PRESTAMO = 20;
    private String carrera; 
  
   public Estudiante(int p_dniSocio, String p_nombre, int p_diasPrestamo,String p_carrera){
    super(p_dniSocio, p_nombre, p_diasPrestamo);
    this.setCarrera(p_carrera);
   }

   private void setCarrera(String p_carrera){
       carrera = p_carrera;
   }
   
   public String getCarrera(){
       return carrera; 
   }
   
   
   //@Override 
   public boolean puedePedir(){
       return super.puedePedir() && this.cantLibrosPrestados() < 3;
   }
   

  public String soyDeLaClase(){
       return "Estudiante";
    }
   
}
