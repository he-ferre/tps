import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class TexTok {

    public static Scanner sc = new Scanner(System.in);


    private ArbolUsuarios miArbol ;
    private TextosMasVistos TextosMasVistos ;

    public TexTok() {
        this.miArbol = new ArbolUsuarios();
        this.TextosMasVistos = new TextosMasVistos();

    }
    // ----------- // ARCHIVOS //-------- //


    // ------ Usuarios ------ //
    public void generarInfoUsuarios() {
        File archivo = new File("ValDFUsuarios.ser");

        try {
            ObjectOutputStream out;

            if (archivo.exists()) {
                out = new MiObjectOutputStream(new FileOutputStream(archivo, true));
            } else {
                out = new ObjectOutputStream(new FileOutputStream(archivo));
            }

            generarInfoUsuariosRec(miArbol.getRaiz(), out);
            out.close();
            System.out.println("Usuarios guardados con éxito.");

        } catch (IOException e) {
            System.out.println("Error al guardar usuarios: " + e.getMessage());
        }
    }

    private void generarInfoUsuariosRec(NodoArbolUsuarios actual, ObjectOutputStream out) throws IOException {
        if (actual != null) {
            UsuarioData usuario = new UsuarioData(actual.getNick(), actual.getPassword());
            out.writeObject(usuario);

            generarInfoUsuariosRec(actual.getAnterior(), out);
            generarInfoUsuariosRec(actual.getSiguiente(), out);
        }
    }


    //Cargo el arbol desde el archivo
    public void cargarArbolDesdeArchivo() {

        File archivo = new File("ValDFUsuarios.ser");

        if (!archivo.exists()){
            System.out.println("No existe archivo de usuarios.");
            return;
        }

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {

            boolean fin = false;

            while(!fin) {
                try {
                    UsuarioData usuario = (UsuarioData) in.readObject();

                    NodoArbolUsuarios nuevo = new NodoArbolUsuarios(usuario.getNick(),usuario.getPassword() );

                    miArbol.insertarUsuario(nuevo);

                } catch (EOFException e) {
                    fin = true; 
                }
            }
            System.out.println("Árbol cargado con éxito desde archivo.");
        } catch (Exception e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }   
    }

    // Subclase para evitar cebecera duplicada
    class MiObjectOutputStream extends ObjectOutputStream {
        public MiObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }
        @Override
        protected void writeStreamHeader() throws IOException {
        reset();
        }
    }

    // ------ Textos------ //


    public void generarInfoTextos() {
        File archivo = new File("ValDFTextos.ser");

        try {
            ObjectOutputStream out;

            if (archivo.exists()) {
                out = new MiObjectOutputStream(new FileOutputStream(archivo, true));
            } else {
                out = new ObjectOutputStream(new FileOutputStream(archivo));
            }

            generarInfoTextosRec(miArbol.getRaiz(), out);
            out.close();
            System.out.println("Textos guardados con éxito.");

        } catch (IOException e) {
            System.out.println("Error al guardar Textos: " + e.getMessage());
        }
    }

    private void generarInfoTextosRec(NodoArbolUsuarios actual, ObjectOutputStream out) throws IOException {
        if(actual != null){
            NodoTexto texto = actual.getTextosCreados();

            while(texto != null){
                TextoData tex = new TextoData(actual.getNick(),texto.getFecha(),texto.getTexto());
                out.writeObject(tex);

                texto = texto.getSiguiente();
            }
            generarInfoTextosRec(actual.getAnterior(), out);
            generarInfoTextosRec(actual.getSiguiente(), out);
        }
    }

    public void cargarTextosDesdeArchivos(){

        File archivo = new File("ValDFTextos.ser");

        if(!archivo.exists()){
            System.out.print("No existe archvio de Textos");
            return;
        }

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))){
            boolean fin = false;

            while(!fin){
                try {
                    TextoData texto = (TextoData) in.readObject();
                    NodoArbolUsuarios actual  = miArbol.buscarUsuario(texto.getNick());
                    NodoTexto nuevo = new NodoTexto(texto.getTexto(),texto.getFecha());

                    if(actual.getTextosCreados() == null){
                        actual.setTextosCreados(nuevo);
                    }else{
                        insertarTexto(nuevo, actual);
                    }
                } catch (EOFException e) {
                    fin = true;  // Fin del archivo sale del bucle
                }catch (ClassNotFoundException e) {
                    System.out.println("Error al leer archivo: " + e.getMessage());
                    fin = true;
                }
            }
            System.out.println("Textos cargado con éxito desde archivo.");
        }catch(IOException e){
            System.out.println("Error al leer archivo: " + e.getMessage());

        }
    }





























    public void identificarse(){
        boolean continuar = false; // para la solicitud de datos repetitiva
        boolean verificado = false;
        String nick = pedirNick();

        //Buscar el nombre de usuario en el arbol
        //mediante el retorno de un nodo no null se verifica

        //datos de prueba
        // String nickPrueba = "Damian";
        // int passwordPrueba = 1234;

        NodoArbolUsuarios usuario = miArbol.buscarUsuario(nick);

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
                                return;
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
                //Como se identifico lo llevo al menu dos
                menuDos(usuario); //Al tener un usuario verificado , para no tener que pasar un nodo del arbol hacia el main , hago el menu dos en TexTok

            }
        }else{
            //El usuario no fue encontrado
            System.out.println("El usuario no fue encontrado: ");
            Main.menuUno();
        }
    }

    public  void menuDos(NodoArbolUsuarios usuario){
        int seleccion = 0; 
        boolean continuar = true;
        do{
            System.out.println("\nMenu Dos:");
            System.out.println("1) Crear texto. ");
            System.out.println("2) Visualizar un texto. ");
            System.out.println("3) Cambiar password. ");
            System.out.println("4) Volver a menu anterior. ");


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
                case 1: // Crear texto.
                    crearTexto(usuario);
                    break;
                case 2:  // Visualizar un texto.
                    visualizarTexto(usuario);
                    break;
                case 3:  //  Cambiar password. 
                    cambiarPassword(usuario);
                    break;
                case 4 :  // Volver a menu anterior.
                    return;
                    
                default:
                    System.out.println(" Opción inválida.");
                    break;
            }

    
        }while (seleccion != 4);
    }
    private String pedirNick(){
        String nick;
        System.out.println("Ingrese su nick: ");
        nick = sc.nextLine();
        return nick;
    }
    private  int pedirPassword(){
        // SOLO DEBE PEDIR LA PASSWORD LA VALIDACION LA HAGO EN OTRO METODO
        //validacio de entrada
        int password = -1;
        boolean continuar = false;
        while(!continuar){
            try{
                System.out.println("Ingrese su password: ");
                password = sc.nextInt();
                continuar = true;
                sc.nextLine(); // limpiar newline
            }catch(Exception e){
                System.out.println("password invalida: la misma solo puede contener numeros");
                sc.nextLine();  // Se limpia el buffer del scanner
            }
        }
        return password;
    }
    private  boolean verificarPassword(int password,NodoArbolUsuarios usuarios){ // se deberia hacer en la clase TexTok??
        boolean verificado = false;
        //Si el usurio existe , y la contraseña coincide con la que tiene en el nodo , devuelve true
        if ((usuarios != null) && (usuarios.getPassword() == password)) {
            verificado = true;
        }
        
        return verificado;
    }
    public  void crearUsuario() {
        String nick = pedirNick(); //pedis el nick

        NodoArbolUsuarios existe = miArbol.buscarUsuario(nick); //busca si el nick ya existe

        if (existe != null) {
            //hacer las dos opciones
            System.out.println("El nombre de usuario ya existe, seleccione otro o vuelva al menu Uno:");

        } else { //Si no existe lo inserta en el arbol
            int password = pedirPassword(); //Pido contraseña
            NodoArbolUsuarios nuevo = new NodoArbolUsuarios(nick, password); //creo el nodo con el nick y contraseña dados

            miArbol.insertarUsuario(nuevo);// lo inserto en el arbolUsuarios

            System.out.println("El usuario " + nick + " fue creado con exito");
        }
    }
    public  void devolverDatos() {
        NodoArbolUsuarios max = miArbol.usuarioMasTextos();
        if (max != null) {
            int cantidad = miArbol.contarTexto(max.getTextosCreados());
            System.out.println("El usuario con mas textos creados es: " + max.getNick());
            System.out.println("Cantidad de textos creados: " + cantidad);
        } else {
            System.out.println("No hay usuarios cargados en el sistema.");
        }
    }
    
    //opcion 1 del menu dos
    private void crearTexto(NodoArbolUsuarios usuario) {
        //Le pido al usuario que me de el texto que quiere poner
        System.out.println("Ingresa el texto que queres publicar: ");
        String texto = sc.nextLine();

        //Llamo al metodo validarTexto que se encuentra en la clase listaTextoCreado para ver si el usuario ya creo un texto igual
        boolean textoRep = validarTexto(texto, usuario.getTextosCreados());

        if (!textoRep) {
            //Si el texto no esta repetido crea el nodo
            NodoTexto nuevo = new NodoTexto(texto,LocalDate.now());  // paso como parametro la fecha actual

            // Lo agregamos al final de la lista de textos creados del usuario
            insertarTexto(nuevo,  usuario);

            // Tambien lo agregamos al final de la lista global de textos mas vistos
            TextosMasVistos.insertarAlFinal(nuevo);

            System.out.println("Texto creado con exito el dia " + nuevo.getFecha());

        } else {
            System.out.println("El texto no pudo ser publicado debido a que ya existe");

        }
    }
        
    public boolean validarTexto(String texto, NodoTexto primeroCreados) {
        return validarTextoRec(primeroCreados , texto);
        
    }

    private boolean validarTextoRec(NodoTexto actual, String texto) {
        boolean existeTexto = false; //Variable que me sirve para poder retornar si el texto se encontro o no
        if(actual != null) {
            //Si el texto del nodo actual es igual al texto 
            if(actual.getTexto().equals(texto)) {  
                existeTexto = true;
            }else{
                //de lo contrario sigo recorriendo 
                existeTexto = validarTextoRec(actual.getSiguiente(),texto);
            }
        }
        return existeTexto; //Si no encontro un texto igual deberia retornar false
    }
    
    
    public void insertarTexto(NodoTexto nuevo, NodoArbolUsuarios usuario) {

        NodoTexto primero = usuario.getTextosCreados();

        if (primero == null) {
            // Si la lista está vacía, el nuevo pasa a ser el primero
            usuario.setTextosCreados(nuevo);
        } else {
            insertarRecursivo(primero, nuevo);
        }
    }
        // Método recursivo para recorrer hasta el último nodo
    private void insertarRecursivo(NodoTexto actual, NodoTexto nuevo) {
        if (actual.getSiguiente() == null) {
            actual.setSiguiente(nuevo);
        } else {
            insertarRecursivo(actual.getSiguiente(), nuevo);
        }
    }
    private  void visualizarTexto(NodoArbolUsuarios usuario) {
        // Buscar el primer texto que no sea propio ni visto
        NodoTexto texto = TextosMasVistos.buscarTextoMasVisto(usuario);

        if (texto != null) {
            System.out.println("Texto mostrado: " + texto.getTexto());
            System.out.println("Fecha de creacion: " + texto.getFecha());
            System.out.println("Vistas actuales: " + texto.getVistas());  // Vistas hasta antes de mostrar 

            // Sumar una vista
            texto.sumarVista();

            // Reordenar la lista de más vistos si corresponde
            TextosMasVistos.reordenarSiEsNecesario(texto);

            // Agregar referencia a la lista de vistos del usuario
            insertarTextoVisto(texto,usuario);

            System.out.println("Total de vistas: " + texto.getVistas()); // Vistas luego de mostrar 
        } else {
            System.out.println("No hay textos para visualizar.");
        }
    }

    public void insertarTextoVisto(NodoTexto texto, NodoArbolUsuarios usuario) {
        NodoVisto nuevo = new NodoVisto(texto);
        NodoVisto primero = usuario.getTextosVisto();
    
        if (primero ==  null) {
            usuario.setTextosVistos(nuevo);
        } else {
            insertarTextoVistoRec(primero, nuevo);
        }
    }
    private void insertarTextoVistoRec(NodoVisto actual, NodoVisto nuevo) {
        if (actual.getVistoSiguiente() == null) {
            actual.setVistoSiguiente(nuevo);
        } else {
            insertarTextoVistoRec(actual.getVistoSiguiente(), nuevo);
        }
    }
    private void cambiarPassword(NodoArbolUsuarios usuario) {
        boolean continuar = false;

        while (!continuar) {
            try {
                System.out.print("Ingrese su contraseña actual: ");
                int passwordActual = sc.nextInt();

                //verificar si coincide con la registrada
                if (passwordActual == usuario.getPassword()) {
                    //pedir nueva contraseña
                    System.out.print("Ingrese su nueva contraseña (solo números): ");
                    int nuevaPassword = sc.nextInt();
                    sc.nextLine();

                    //confirmar nueva contraseña
                    System.out.print("Confirme su nueva contraseña: ");
                    int confirmacion = sc.nextInt();
                    sc.nextLine();

                    if (nuevaPassword == confirmacion) {
                        usuario.setPassword(nuevaPassword);
                        System.out.println("Password modificada correctamente.");
                        continuar = true;
                    } else {
                        System.out.println("Las contraseñas no coinciden. Intenta nuevamente.");
                    }
                } else {
                    System.out.println("Password incorrecta. Intenta nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Error ,la contraseña debe ser numerica.");
                sc.nextLine(); // limpiar buffer

            }
        }

    }


}