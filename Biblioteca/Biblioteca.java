import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.HashSet;

public class Biblioteca {
    private String nombre;
    private ArrayList<Socio> socios;
    private ArrayList<Libro> libros;

    public Biblioteca(String p_nombre) {
        this.setNombre(p_nombre);
        this.setSocios(new ArrayList<Socio>());
        this.setLibros(new ArrayList<Libro>());
    }

    public Biblioteca(String p_nombre, ArrayList<Socio> p_socios, ArrayList<Libro> p_libros) {
        this.setNombre(p_nombre);
        this.setSocios(p_socios);
        this.setLibros(p_libros);
    }

    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    private void setSocios(ArrayList<Socio> p_socios) {
        this.socios = p_socios;
    }

    private void setLibros(ArrayList<Libro> p_libros) {
        this.libros = p_libros;
    }

    public String getNombre() {
        return this.nombre;
    }

    public ArrayList<Socio> getSocios() {
        return this.socios;
    }

    public ArrayList<Libro> getLibros() {
        return this.libros;
    }

    public Socio buscarSocio(int p_dni) {
        for (Socio socio : this.getSocios()) {
            if (socio.getDniSocio() == p_dni) {
                return socio;
            }
        }
        return null;
    }

    public String listaDeTitulos() {
        HashSet<String> titulosUnicos = new HashSet<String>();
        for (Libro libro : this.getLibros()) {
            titulosUnicos.add(libro.getTitulo());
        }

        String lista = "Títulos en Biblioteca:\n";
        for (String titulo : titulosUnicos) {
            lista += "- " + titulo + "\n";
        }
        return lista;
    }

    public String listaDeLibros() {
        String lista = "Lista de Libros:\n";
        int i = 1;
        for (Libro libro : this.getLibros()) {
            String prestado = libro.prestado() ? "(Si)" : "(No)";
            lista += i + ") Titulo: " + libro.getTitulo() + " || Prestado: " + prestado + "\n";
            i++;
        }
        return lista;
    }

    public String listaDeDocentesResponsables() {
        String lista = "Lista de Docentes Responsables:\n";
        for (Socio socio : this.getSocios()) {
            if (socio.soyDeLaClase().equals("Docente")) {
                Docente docente = (Docente) socio;
                if (docente.esResponsable()) {
                    lista += "* " + docente.toString() + "\n";
                }
            }
        }
        return lista;
    }

public boolean prestarLibro(Calendar p_fechaRetiro, Socio p_socio, Libro p_libro){
        for(Libro l : libros){
            if(l == p_libro){
                for(Socio s : socios){
                    if(s == p_socio){
                        if(s.puedePedir() && !l.prestado()){
                            Prestamo prestamo = new Prestamo(p_fechaRetiro, p_socio, p_libro);
                            s.agregarPrestamo(prestamo);
                            l.agregarPrestamo(prestamo);
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public void devolverLibro(Libro p_libro) throws LibroNoPrestadoException{
        Calendar fechaHoy = new GregorianCalendar();
        if(!(p_libro.prestado())){
            throw new LibroNoPrestadoException(p_libro);
        }
        p_libro.ultimoPrestamo().registrarFechaDevolucion(fechaHoy);
    }
    
    public ArrayList<Prestamo> prestamosVencidos(){
        Calendar fechaHoy = new GregorianCalendar();
        ArrayList<Prestamo> prestamosVencidos = new ArrayList<Prestamo>();
        for(Socio s : socios){
            for(Prestamo p : s.getPrestamos()){
                if(p.getFechaDevolucion() == null & p.vencido(fechaHoy)){
                    prestamosVencidos.add(p);
                }
            }
        }
        return prestamosVencidos;
    }
    
    public ArrayList<Socio> docentesResponsables(){
        ArrayList<Socio> docentesResponsables = new ArrayList<Socio>();
        for(Socio d : socios){
            if((d.soyDeLaClase().equals("Docente") && ((Docente)d).esResponsable())){
                docentesResponsables.add(d);
            }
        }
        return docentesResponsables; 
    }
    
    public String quienTieneElLibro(Libro p_libro) throws LibroNoPrestadoException{
        for(Socio s : socios){
            for(Prestamo p : s.getPrestamos()){
                if(p.getLibro() == p_libro && p.getFechaDevolucion() == null){
                    return s.getNombre();
                }
            }
        }
        throw new LibroNoPrestadoException(p_libro);
    }
     /********* nuevoLibro() *******************************************************************/   
   public void nuevoLibro(String p_titulo, int p_edicion, String p_editorial, int p_anio) {
       
    Libro nuevoLibro = new Libro(p_titulo, p_edicion, p_editorial, p_anio);
    this.getLibros().add(nuevoLibro);
}
/**************** buscar libro ************************************/
public Libro buscarLibro(String p_titulo) {
        for (Libro libro : this.getLibros()) {
            if (libro.getTitulo().equalsIgnoreCase(p_titulo)) {  
                return libro;
            }
        }
        return null;
    }
/***************** nuevoSocioEstudiante() *************************************************/
public void nuevoSocioEstudiante(int p_dniSocio, String p_nombre, String p_carrera) {
    Estudiante nuevoEstudiante = new Estudiante(p_dniSocio, p_nombre, 5, p_carrera);
    this.getSocios().add(nuevoEstudiante);
}

/***************** nuevoSocioDocente() ****************************************************/
public void nuevoSocioDocente(int p_dniSocio, String p_nombre, String p_area) {
    Docente nuevoDocente = new Docente(p_dniSocio, p_nombre, 10, p_area);
    this.getSocios().add(nuevoDocente);
}
/****************** listaDeSocios() Formato 1*******************************************************/
public String listaDeSocios() {
    String lista = "Lista de Socios: \n\n";
    int contador = 1;
    for (Socio socio : this.getSocios()) {
        lista += contador + ") " + socio.toString() + "\n";
        contador++;
    }
    lista += "**************************************\n";
    lista += " Cantidad de Socios del tipo Estudiante: " + this.cantidadDeSociosPorTipo("Estudiante") + "\n";
    lista += " Cantidad de Socios del tipo Docente: " + this.cantidadDeSociosPorTipo("Docente") + "\n";
    lista += "**************************************\n";
    return lista;
}
/****************** cantidadSociosPorTipo() ***********************************************/
public int cantidadDeSociosPorTipo(String p_tipo) {
    int cantidad = 0;
    for (Socio socio : this.getSocios()) {
        if (socio.soyDeLaClase().equals(p_tipo)) {
            cantidad++;
        }
    }
    return cantidad;
}
}
