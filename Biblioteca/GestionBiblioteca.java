package biblioteca;

import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class GestionBiblioteca {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central");
        
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
                    // --- TAREA INTEGRANTE 3 ---
                    // Imprimir las respuestas a: "¿Cuál es la lista de libros? ¿Y la de socios?"
                    // Llamar a biblioteca.listaDeLibros() y biblioteca.listaDeSocios().
                    
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
}
