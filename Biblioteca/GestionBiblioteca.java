package biblioteca;

import java.util.*;
import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Clase principal ejecutable del sistema de gestión de la biblioteca.
 * Implementa una interfaz de consola con menús interactivos para administrar
 * libros, socios, registrar préstamos y devoluciones, y realizar consultas específicas.
 * 
 * @author Berton Agustin, Gonzalez Avril Araceli, Balenzuela Tobias, Acevedo Horacio, Fernandez Zalazar Jeremias, Rodriguez Martemucci Lucciana
 * @version 1.0
 */

public class GestionBiblioteca {

    /** Instancia estática principal de la biblioteca sobre la cual operará el sistema. */
    static Biblioteca biblioteca = new Biblioteca("Biblioteca Central");

    /**
     * Método principal que inicia la ejecución del programa.
     * Contiene el bucle del menú principal que permite acceder a las distintas
     * funciones del sistema hasta que el usuario decida salir.
     * 
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        
        cargarDatosPrueba();
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

                    mostrarSubMenu_1();
                    
                    System.out.println("Datos cargados exitosamente.");
                    break;

                case 2:
                    System.out.println("\n--- SIMULACIÓN DE MOVIMIENTOS ---");
                    simularMovimientos(teclado);
                    break;

                case 3:
                    System.out.println("\n--- LISTADOS GENERALES ---");
                    //metodo para listar libros
                    System.out.println(biblioteca.listaDeLibros());
                    //metodo para listar socios
                    System.out.println(biblioteca.listaDeSocios());
                    
                    break;

                case 4:
                    System.out.println("\n--- CONSULTAS ESPECÍFICAS ---");
                    //metodo para imprimir en pantalla el numero total de socios del tipo Estudiante
                    System.out.println("\nEl numero de socios que son estudiantes registrados en la biblioteca son: "+biblioteca.cantidadDeSociosPorTipo("Estudiante"));
                    //metodo para mostrar en pantalla la lista de docentes responsables
                    System.out.println("\n\nY estos son los docentes responsables:\n"+biblioteca.docentesResponsables());
                    break;

                case 5:
                    System.out.println("\n--- CONSULTA DE LIBRO ESPECÍFICO ---");
                     try {
                        Libro libroBuscado = biblioteca.buscarLibro("Programando con JAVA");
                    if(libroBuscado == null){
                        System.out.println("El libro 'Programando con Java' no esta cargado en la biblioteca.");
                    } else {
                        String nombre = biblioteca.quienTieneElLibro(libroBuscado);
                        System.out.println("El libro 'Programando con Java' lo tiene prestado: " + nombre);
                    }
                    } catch (LibroNoPrestadoException e){
                        System.out.println(e.getMessage());
                    }
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
    
    /**
     * Muestra y gestiona el sub-menú para el alta y baja de libros y socios.
     */
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

    /**
     * Muestra y gestiona las operaciones de tratamiento sobre los libros (Alta/Baja).
     */
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
        
    /**
     * Interactúa con el usuario para registrar un nuevo libro en la biblioteca.
     * Valida que el título no exista previamente en el sistema.
     */    
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
    
 /**
     * Interactúa con el usuario para dar de baja (eliminar) un libro de la biblioteca
     * mediante la búsqueda de su título.
     */
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
    
 /**
     * Muestra y gestiona las operaciones de tratamiento sobre los socios (Alta/Baja).
     */
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
    
 /**
     * Interactúa con el usuario para registrar un nuevo socio (Estudiante o Docente).
     * Valida que el DNI no se encuentre ya registrado.
     */
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
    
/**
     * Interactúa con el usuario para dar de baja un socio mediante su DNI.
     * Valida que el socio no posea libros prestados actualmente.
     */
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
/**
     * Instancia y agrega a la biblioteca un conjunto de libros y socios 
     * por defecto para facilitar las pruebas del sistema.
     */
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

    /**
     * Despliega un sub-menú para simular transacciones de la biblioteca 
     * (registrar préstamos y devoluciones).
     * 
     * @param teclado Objeto Scanner para la lectura de datos por consola.
     */
public static void simularMovimientos(Scanner teclado) {
        int opcionMov = -1;
        do {
            System.out.println("\n--- SUB-MENÚ MOVIMIENTOS ---");
            System.out.println("1. Registrar Préstamo");
            System.out.println("2. Registrar Devolución");
            System.out.println("0. Volver al menú principal");
            System.out.print("Elija una opción: ");
            
            while (!teclado.hasNextInt()) {
                System.out.println("Debe ingresar un número.");
                teclado.next();
                System.out.print("Elija una opción: ");
            }
            opcionMov = teclado.nextInt();
            teclado.nextLine(); 

            switch (opcionMov) {
                case 1:
                    registrarPrestamoUI(teclado);
                    break;
                case 2:
                    registrarDevolucionUI(teclado);
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcionMov != 0);
    }

    /**
     * Interfaz de usuario para registrar un préstamo.
     * Pide DNI y título, busca las instancias correspondientes en la biblioteca 
     * y genera la solicitud de préstamo si se cumplen las reglas de negocio.
     * 
     * @param teclado Objeto Scanner para la lectura de datos por consola.
     */
    public static void registrarPrestamoUI(Scanner teclado) {
        System.out.print("Ingrese el DNI del socio: ");
        int dni = teclado.nextInt();
        teclado.nextLine(); 

        Socio socio = biblioteca.buscarSocio(dni);
        if (socio == null) {
            System.out.println("Error: No existe un socio con ese DNI.");
            return;
        }

        System.out.print("Ingrese el título del libro a prestar: ");
        String titulo = teclado.nextLine();
        Libro libro = biblioteca.buscarLibro(titulo);

        if (libro == null) {
            System.out.println("Error: El libro no existe en la biblioteca.");
            return;
        }

        // Instancia de fecha requerida para el registro del préstamo
        Calendar fechaRetiro = new GregorianCalendar();

        boolean exito = biblioteca.prestarLibro(fechaRetiro, socio, libro);
        
        if (exito) {
            System.out.println("Préstamo registrado exitosamente para: " + socio.getNombre());
        } else {
            System.out.println("Préstamo rechazado. (El libro ya está prestado, el socio adeuda libros o superó su límite)");
        }
    }

    /**
     * Interfaz de usuario para registrar la devolución de un libro.
     * Atrapa excepciones en caso de que el libro no figure como prestado en el sistema.
     * 
     * @param teclado Objeto Scanner para la lectura de datos por consola.
     */
    public static void registrarDevolucionUI(Scanner teclado) {
        System.out.print("Ingrese el título del libro a devolver: ");
        String titulo = teclado.nextLine();
        Libro libro = biblioteca.buscarLibro(titulo);

        if (libro == null) {
            System.out.println("Error: El libro no existe en la biblioteca.");
            return;
        }

        // Bloque obligatorio para capturar el error si el libro ya estaba en la biblioteca
        try {
            biblioteca.devolverLibro(libro);
            System.out.println("Devolución registrada exitosamente. El libro vuelve a estar disponible.");
        } catch (LibroNoPrestadoException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
