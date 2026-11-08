package biblioteca;

import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class GestionBiblioteca {

    static Biblioteca biblioteca = new Biblioteca("Biblioteca Central");
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        
        do {
            System.out.println("\n=== MENÚ DE GESTIÓN DE BIBLIOTECA ===");
            System.out.println("1. Cargar datos iniciales (Socios y Libros)");
            System.out.println("2. Simular préstamos y devoluciones");
            System.out.println("3. Listados generales (Libros y Socios)");
            System.out.println("4. Consultas específicas (Cant. Estudiantes y Docentes Responsables)");
            System.out.println("5. Consultar quién tiene el libro 'Programando con JAVA'");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");
            
            opcion = teclado.nextInt();
            teclado.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.println("\n--- CARGANDO DATOS INICIALES ---");
                    // --- TAREA INTEGRANTE 1 ---
                     mostrarSubMenu_1();
                    // Usar metodos nuevoLibro(), nuevoSocioEstudiante() y nuevoSocioDocente().
                    // Asegurarse de cargar el libro "Programando con JAVA".
                    
                    System.out.println("Datos cargados exitosamente.");
                    break;

                case 2:
                    System.out.println("\n--- SIMULACIÓN DE MOVIMIENTOS ---");
                    // --- TAREA INTEGRANTE 2 ---
                    // Buscar un socio, buscar un libro y usar el método prestarLibro() o devolverLibro().
                    // Usar Calendar para las fechas de retiro.
                    
                    break;

                case 3:
                    System.out.println("\n--- LISTADOS GENERALES ---");
                    //metodo para listar libros
                    System.out.println(biblbioteca.listaDeLibros());
                    //metodo para listar socios
                    System.out.println(biblioteca.listaDeSocios());
                    
                    break;

                case 4:
                    System.out.println("\n--- CONSULTAS ESPECÍFICAS ---");
                    // --- TAREA INTEGRANTE 4 ---
                    // Imprimir las respuestas a: "¿Qué cantidad de socios de tipo Estudiante hay?"
                    // y "¿Cuál es la lista de docentes que nunca han adeudado ni adeudan libros?"
                    // Llamar a cantidadDeSociosPorTipo("Estudiante") y listaDeDocentesResponsables().
                    
                    break;

                case 5:
                    System.out.println("\n--- CONSULTA DE LIBRO ESPECÍFICO ---");
                    // --- TAREA INTEGRANTE 5 ---
                    // Responder a: "¿Qué socio tiene prestado el libro 'Programando con JAVA'?"
                    // Implementar aquí el bloque try-catch llamando a quienTieneElLibro().
                    /* Ejemplo de estructura:
                    try {
                        // buscar el objeto libro "Programando con JAVA"
                        // String nombre = biblioteca.quienTieneElLibro(libroBuscado);
                        // imprimir nombre
                    } catch (LibroNoPrestadoException e) {
                        System.out.println(e.getMessage());
                    }
                    */
                    
                    break;

                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción incorrecta. Intente nuevamente.");
            }
        } while (opcion != 6);
        
        teclado.close();
    }
    /****** Parte Integrante 1 Acevedo horacio andres *************************/
     public static void mostrarSubMenu_1() {
      ArrayList<String> ops = new ArrayList<>();
        ops.add("Libros");
        ops.add("Socios");
                
        Menu menu = new Menu("Alta-Baja-Libros", ops);
        int opcion;
        do {
        opcion = menu.elegir();
        menu.limpiarPantalla();
        System.out.println("Elegiste: " + opcion);
        
        switch (opcion) {
            case 1 : tratarLibro();
                     break;
            case 2 : tratarSocio();
                     break;
            default: System.out.println("SALISTE");
                     break;
        }
    } while(opcion!=0);
  
    }
    
    public static void tratarLibro(){
     ArrayList<String> ops = new ArrayList<>();
        ops.add("Alta");
        ops.add("Baja");
        //ops.add("Modificar");        
        Menu menu = new Menu("Tratamientos de Libros", ops);
        int opcion;
        do {
        opcion = menu.elegir();
        menu.limpiarPantalla();
        System.out.println("Elegiste: " + opcion);
        
        switch (opcion) {
            case 1 : altaLibros();
                     break;
            case 2 : darDeBajaLibro();
                     break;
         //   case 3 : break;
            default: System.out.println("SALISTE");
                     break;
        }
    } while(opcion!=0);
  
    }
        
    
        
    public static void altaLibros(){
        
        Scanner teclado = new Scanner(System.in);
        
    System.out.print("Titulo: ");
    String titulo = teclado.nextLine();

    // 1. Validar si ya esta en la coleccion
    if(biblioteca.buscarLibro(titulo) != null){
        System.out.println("Ya existe un libro con ese titulo.\n");
        return;
    }

    // 2. Si no existe, pido el resto de los datos
    System.out.print("Edicion: ");
    int edicion = teclado.nextInt();
    teclado.nextLine(); // limpia el enter

    System.out.print("Editorial: ");
    String editorial = teclado.nextLine();

    System.out.print("Anio: ");
    int anio = teclado.nextInt();
    teclado.nextLine(); // limpia el enter

    // 3. Instanciar el nuevo libro y agregarlo
    //Libro newLibro = new Libro(titulo, edicion, editorial, anio);
    biblioteca.nuevoLibro(titulo,edicion,editorial,anio);

    System.out.println("Libro agregado.");
}
    
 /**************** dar baja a libros ***************************/
 public static void darDeBajaLibro(){
    Scanner teclado = new Scanner(System.in);

    System.out.print("Titulo a dar de baja: ");
    String titulo = teclado.nextLine();

    // 1. Validar si existe en la coleccion
    Libro libro = biblioteca.buscarLibro(titulo);
    if(libro == null){
        System.out.println("No existe un libro con ese titulo.");
        return;
    }

    // 2. Si existe, lo doy de baja
    biblioteca.getLibros().remove(libro);
    System.out.println("Libro dado de baja.");
}
    
 /*************** tratar socios ******************************/   
    public static void tratarSocio(){
      ArrayList<String> ops = new ArrayList<>();
        ops.add("Alta");
        ops.add("Baja");
      //  ops.add("Modificar");        
        Menu menu = new Menu("Tratamiento de Socios", ops);
        int opcion;
        do {
        opcion = menu.elegir();
        menu.limpiarPantalla();
        System.out.println("Elegiste: " + opcion);
        
        switch (opcion) {
            case 1 : altaSocio();
                     break;
            case 2 : darDeBajaSocio();
                     break;
            default: System.out.println("SALISTE");
                     break;
        }
    } while(opcion!=0);
  
 }
 /************** alta socio ******************************/
 public static void altaSocio(){
     
    Scanner teclado = new Scanner(System.in);

    System.out.print("DNI: ");
    int dni = teclado.nextInt();
    teclado.nextLine();

    // 1. Validar si ya existe
    if(biblioteca.buscarSocio(dni) != null){
        System.out.println("Ya existe un socio con ese DNI.");
        return;
    }

    System.out.print("Nombre: ");
    String nombre = teclado.nextLine();

    // 2. Preguntar que tipo de socio es
    System.out.println("Tipo de socio: 1- Estudiante  2- Docente");
    System.out.print("Opcion: ");
    int tipo = teclado.nextInt();
    teclado.nextLine();

    Socio nuevoSocio = null;

    if(tipo == 1){
        System.out.print("Carrera: ");
        String carrera = teclado.nextLine();
        biblioteca.nuevoSocioEstudiante(dni, nombre, carrera);
    } else if(tipo == 2){
        System.out.print("Dias de prestamo: ");
        int diasPrestamo = teclado.nextInt();
        teclado.nextLine();

        System.out.print("Area: ");
        String area = teclado.nextLine();
        biblioteca.nuevoSocioDocente(dni, nombre, area);
    } else {
        System.out.println("Opcion invalida.");
        return;
    }

    // 3. Instanciar y agregar
    //biblioteca.agregarSocio(nuevoSocio);
    System.out.println("Socio agregado.");
}
/*************** baja de socios *************************************/
public static void darDeBajaSocio(){
    Scanner teclado = new Scanner(System.in);

    System.out.print("DNI del socio a dar de baja: ");
    int dni = teclado.nextInt();
    teclado.nextLine();

    // 1. Validar si existe
    Socio socio = biblioteca.buscarSocio(dni);
    if(socio == null){
        System.out.println("No existe un socio con ese DNI.");
        return;
    }

    // 2. Validar que no tenga libros prestados
    if(socio.cantLibrosPrestados() > 0){
        System.out.println("No se puede dar de baja, tiene libros prestados.");
        return;
    }

    // 3. Si pasa las validaciones, lo doy de baja
    biblioteca.getSocios().remove(socio);
    System.out.println("Socio dado de baja.");
} 
/************** datos de pruebas ************************************************/
public static void cargarDatosPrueba(){
    // --- Libros ---
    Libro libro1 = new Libro("Programacion en Java",1, "Deitel",2015);
    Libro libro2 = new Libro("Algoritmos y Programacion",3,"Joyanes Aguilar",2008);
    Libro libro3 = new Libro("Base de Datos",6, "Silberschatz",2010);
    //biblioteca.nuevoLibro(titulo,edicion,editorial,anio);
    biblioteca.nuevoLibro(libro1.getTitulo(),libro1.getEdicion(),libro1.getEditorial(),libro1.getAnio());
    biblioteca.nuevoLibro(libro2.getTitulo(),libro2.getEdicion(),libro2.getEditorial(),libro2.getAnio());
    biblioteca.nuevoLibro(libro3.getTitulo(),libro3.getEdicion(),libro3.getEditorial(),libro3.getAnio());
    
    // --- Socios Estudiantes ---
    Estudiante est_1 = new Estudiante(40123456, "Ana Perez", Estudiante.DIAS_PRESTAMO, "Ingenieria en Sistemas");
    Estudiante est_2 = new Estudiante(40987654, "Juan Lopez", Estudiante.DIAS_PRESTAMO, "Licenciatura en Administracion");
    //Estudiante(int p_dniSocio, String p_nombre, int p_diasPrestamo,String p_carrera)
    biblioteca.nuevoSocioEstudiante(est_1.getDniSocio(),est_1.getNombre(),est_1.getCarrera());
    biblioteca.nuevoSocioEstudiante(est_2.getDniSocio(),est_2.getNombre(),est_2.getCarrera());

    // --- Socios Docentes ---
    Docente docente1 = new Docente(25123456, "Carlos Gomez", 30, "Matematica");
    Docente docente2 = new Docente(27567890, "Maria Fernandez", 30, "Informatica");
    // nuevoSocioDocente(int p_dniSocio, String p_nombre, String p_area) 
    biblioteca.nuevoSocioDocente(docente1.getDniSocio(),docente1.getNombre(),docente1.getArea());
    biblioteca.nuevoSocioDocente(docente2.getDniSocio(),docente2.getNombre(),docente2.getArea());
}   

}
