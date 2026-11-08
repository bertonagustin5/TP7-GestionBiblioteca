package biblioteca;
/**
 * Write a description of class Menu here.
 * 
 * @author Acevedo Horacio Andres 
 * @version 1.O
*/
import java.util.ArrayList;
import java.util.Scanner;

public class Menu
{
    private String titulo;
    private ArrayList<String> opciones;
    private Scanner teclado;

    public Menu(String titulo, ArrayList<String> opciones)
    {
        this.titulo = titulo;
        this.opciones = opciones;
        this.teclado = new Scanner(System.in);
    }

    public void mostrar()
    {
        System.out.println("\n=== " + titulo + " ===");
        for(int i = 0; i < opciones.size(); i++){
            System.out.println((i + 1) + ". " + opciones.get(i));
        }
        System.out.println("0. Salir");
    }

    // Devuelve la opción elegida (0 a opciones.size())
    public int elegir()
    {
        int opcion = -1;
        do {
            mostrar();
            System.out.print("Ingrese una opción: ");
            while(!teclado.hasNextInt()){
                System.out.println("Debe ingresar un número.");
                teclado.next();
                System.out.print("Ingrese una opción: ");
            }
            opcion = teclado.nextInt();
            if(opcion < 0 || opcion > opciones.size()){
                System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while(opcion < 0 || opcion > opciones.size());
        
        return opcion;
    }

    // Si querés que devuelva el texto, no el número:
    public String elegirTexto()
    {
        int num = elegir();
        if(num == 0){
            return "Salir";
        }
        return opciones.get(num - 1);
    }
    
    public void limpiarPantalla() {
        
       for(int i=0;i<40;i++) {System.out.println();} 
             
    }
}
