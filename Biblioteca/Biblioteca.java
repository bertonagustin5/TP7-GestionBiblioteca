import java.util.ArrayList;
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
}
