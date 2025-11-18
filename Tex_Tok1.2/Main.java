
import java.util.Scanner;

public class Main{

    public static Scanner sc = new Scanner(System.in);
    public static TexTok TexTok = new TexTok();//instancia pricipal de textok

    public static void main(String[] args) {

        menuUno();
    }

    public static void menuUno(){
        int seleccion = 0; 
        boolean continuar = true;
        do{
            System.out.println("\nMenu Uno:");
            System.out.println("1) Identificarse.");
            System.out.println("2) Crear usuario.");
            System.out.println("4) Devolver los datos del usuario que mas textos creo.");
            System.out.println("6) Salir.");


            continuar = true;

            while(continuar){
                try {
                    seleccion = sc.nextInt();
                    sc.nextLine();
                    continuar = false;
                } catch (Exception e) {
                System.out.println("Ocurrio un error: Por favor seleccione una opción válida.");
                    sc.nextLine();
                }
            }
            switch (seleccion) {
                case 1: // identificarse
                    TexTok.identificarse();
                    break;
                case 2:  // crear usuario
                    TexTok.crearUsuario();
                    break;
                case 4:  // Devolver datos
                    TexTok.devolverDatos();
                    break;
                case 6 :  // salir
                    //guardar datos
                    break;
                default:
                    System.out.println(" Opción inválida.");
                    break;
            }

    
        }while (seleccion != 6);
    }

    
}