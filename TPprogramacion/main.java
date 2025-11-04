import java.util.Scanner;

public class main {

    public static Scanner sc = new Scanner(System.in);
    public static arbolUsuarios miArbol = new arbolUsuarios(); //instancia del arbolUsuarios para poder acceder desde cualquier metodo del main sin pasarlo como parametro
    public static void main(String [] args){

        menuUno();
    }

    // TODO: se deben cargar los datos desde los archivos


    // Menu UNO 

    public static void menuUno(){
        System.out.println("Menu Uno:");
        // colocar boolean para finalizar flujo al seleccionar la opcion 6 ✓
        boolean continuar = false;
        while (!continuar) { 
            try {
                System.out.println("1) Identificarse.");
                System.out.println("2) Crear usuario.");
                System.out.println("4) Devolver los datos del usuario que mas textos creo.");
                System.out.println("6) Salir.");
                int seleccion = sc.nextInt();
                sc.nextLine();
                if(seleccion == 1){
                    // La identificacion deberia devolver un nodo para saber si se puede pasar al menu 2 este nodo va a ser != null
                    identificarse();
                }else if (seleccion == 2){
                    crearUsuario();
                }else if (seleccion == 4){
                    devolverDatos();
                }else if(seleccion == 6){
                    salir();
                    continuar = true;
                }else{
                    System.out.println("Opcion invalida: Por favor seleccione la opcion correspondiente.");
                }
                
            } catch (Exception e) {
                System.out.println("Ocurrio un error: Por favor seleccione la opcion correspondiente.");
                sc.nextLine();
            }
        }  
    }
    private static void identificarse(){
        boolean continuar = false; // para la solicitud de datos repetitiva
        boolean verificado = false;
        String nick = pedirNick();
        //Buscar el nombre de usuario en el arbol
        //mediante el retorno de un nodo no null se verifica

        //datos de prueba
        // String nickPrueba = "Damian";
        // int passwordPrueba = 1234;

        nodoArbolUsuarios usuario = miArbol.buscarUsuario(nick);

        if((usuario != null) && (usuario.getNick().equals(nick))){// esta condicion debe ser que el nodo (! vacio ) y el nick sean iguales
            // Compara la contraseña ingresada con la guardada en el nodo del usuario
            while(!verificado){
                int password = pedirPassword();
                verificado = verificarPassword(password,usuario); // pasa parametro el nodo del usuario y password (Para pruebas cambiar usuario por passwordPrueba)
                if(verificado != true){
                    while(!continuar){
                        try{
                            System.out.println("Password incorrecta: Elija una de las siguientes opciones");
                            System.out.println("1) volver a ingresar password: ");
                            System.out.println("2) volver a Menu UNO :");
                            int eleccion = sc.nextInt();
                            if(eleccion == 1){
                                continuar = true;
                            }else if (eleccion == 2){
                                menuUno();
                            }else {
                                System.out.print("Eleccion incorrecta intente nuevamente: ");
                            }
                        }catch(Exception e){
                            System.out.println("Ocurrio un error: Por favor seleccione la opcion correspondiente.");
                            sc.nextLine();
                        }
                    }
                }
                continuar = false;
            }
            if(verificado == true){
                //usuario identificado con exito
                System.out.println("Usuario identificado con exito: ");
                //TODO: seguir con menu DOS
                // Pasa al segundo menu () debe "recordar" al usuario ingresado
            }
        }else{
            //El usuario no fue encontrado
            System.out.println("El usuario no fue encontrado: ");
            //menuUno();
        }

    }
    private static void crearUsuario(){
        String nick = pedirNick();
        // Si no existe el nick pedirNick retorna "" 
        if(nick.compareTo("") == 0){
            //pide password, al pedir esta password tambien la va a comparar con los nodos , pero no va a encontrar nodo usuario (por que todavia no esta creado)
            

        }else{
            //hacer las dos opciones
            System.out.println("El nombre de usuario ya existe, seleccione otro o vuelva al menu Uno:");
        }
    }
    private static void devolverDatos(){
        //devuelve los datos del usuario que mas textos creo
        // TODO: recorrer arbol y devolver el usuario
    }
    private static void salir(){
        // Se guardan los datos en los archivos









    }
    private static String pedirNick(){
        String nick;
        System.out.println("Ingrese su nick: ");
        nick = sc.nextLine();
        return nick;
    }
    private static int pedirPassword(){
        // SOLO DEBE PEDIR LA PASSWORD LA VALIDACION LA HAGO EN OTRO METODO
        //validacio de entrada
        int password = -1;
        boolean continuar = false;
        while(!continuar){
            try{
                System.out.println("Ingrese su password: ");
                password = sc.nextInt();
                continuar = true;
            }catch(Exception e){
                System.out.println("password invalida: la misma solo puede contener numeros");
                sc.nextLine();  // Se limpia el buffer del scanner
            }
        }
        return password;
    }
    private static boolean verificarPassword(int password,nodoArbolUsuarios usuarios){
        //TODO: Implementar comparacion 
        // boolean verificado = false;
        // if(password == passwordPrueba){
        //     verificado = true;
        // }
        return true;
    }
}
