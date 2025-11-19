public class ArbolUsuarios {
    private NodoArbolUsuarios raiz;

    public ArbolUsuarios(){
        this.raiz = null;
    }


    public NodoArbolUsuarios buscarUsuario(String nick){
        return buscarUsuarioRecursivo(raiz,nick);
    }
    private NodoArbolUsuarios buscarUsuarioRecursivo(NodoArbolUsuarios actual, String nick){
        NodoArbolUsuarios usuario = null;

        if(actual != null){
            if(nick.equals(actual.getNick())){
                usuario = actual; //si se encontro el nick se guarda en el nodo
            }else if(nick.compareTo(actual.getNick()) < 0){
                usuario = buscarUsuarioRecursivo(actual.getAnterior(), nick);
            }else if (nick.compareTo(actual.getNick()) > 0) {
                usuario = buscarUsuarioRecursivo(actual.getSiguiente(), nick);
            }
        }
        return usuario; // devuelve el usuario , si no se encontro devuelve null 
    }
    public void insertarUsuario(NodoArbolUsuarios nuevo) {
        //Me fijo si el arbol no esta vacio , en caso de estarlo , mi nuevo nodo pasa a ser la raiz
        if (raiz != null) {
            insertarUsuarioRecursivo(raiz, nuevo);
        } else {
            raiz = nuevo;
        }
    }
    private void insertarUsuarioRecursivo(NodoArbolUsuarios actual, NodoArbolUsuarios nuevo) {

        //Opcion 1: Si el nick nuevo es menor que el actual , va a ir al subarbol izquierdo
        if (nuevo.getNick().compareTo(actual.getNick()) < 0) {

            //Si anterior es null , inserta el nuevo nodo , de lo contrario sigue recorriendo el subarbol por la izquierda
            if (actual.getAnterior() == null) {
                actual.setAnterior(nuevo);
            } else {
                insertarUsuarioRecursivo(actual.getAnterior(), nuevo);
            }

            //Opcion 2:Si el nick nuevo es mayor que el actual , va a ir al subarbol derecho 
        } else if (nuevo.getNick().compareTo(actual.getNick()) > 0) {

            //Si siguiente es null , inserta el nuevo nodo , de lo contrario sigue recorriendo el subarbol por la derecha
            if (actual.getSiguiente() == null) {
                actual.setSiguiente(nuevo);
            } else {
                insertarUsuarioRecursivo(actual.getSiguiente(), nuevo);
            }
        }

    }
    public NodoArbolUsuarios usuarioMasTextos() {
        NodoArbolUsuarios max; //Puntero que voy a usar para que me indique el usuario con mas textos
        max = usuarioMasTextosRecursivo(raiz, null);
        return max;
    }

    private NodoArbolUsuarios usuarioMasTextosRecursivo(NodoArbolUsuarios actual, NodoArbolUsuarios max) {
        if (actual != null) {

            // Si max todavía no existe o el usuario actual tiene más textos
            if (max == null || contarTexto(actual.getTextosCreados()) > contarTexto(max.getTextosCreados())) {
                max = actual;
            }

            max = usuarioMasTextosRecursivo(actual.getAnterior(), max);
            max = usuarioMasTextosRecursivo(actual.getSiguiente(), max);
        }

        return max;
    }

    //Metodo que cuenta la cantidad de textos creados en la lista
    public int contarTexto(NodoTexto primeroCreados) {
        int cantidad = 0; //variable que uso como contador
        cantidad = contarTextoRec(primeroCreados, cantidad);

        return cantidad;
    }

    private int contarTextoRec(NodoTexto actual, int cantidad) {
        if (actual != null) {
            cantidad = contarTextoRec(actual.getSiguiente(), cantidad + 1);
        }
        return cantidad;
    }
    public NodoArbolUsuarios getRaiz(){
        return raiz;
    }

}
