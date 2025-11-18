public class TextosMasVistos {
    private NodoTexto primero; //se relaciona con el atributo menosVistoSiguiente;

    public TextosMasVistos() {
        this.primero = null;
    }

    public NodoTexto getPrimeroMasVistos() {
        return primero;
    }

    public void setPrimeroMasVistos(NodoTexto primeroMasVistos) {
        this.primero = primeroMasVistos;
    }

    // Inserta al final el texto creado por usuario (se usa al crear un nuevo texto)
    public void insertarAlFinal(NodoTexto nuevo) {
        if (primero == null) {
            primero = nuevo;
        } else {
            insertarRec(primero, nuevo);
        }
    }
    private void insertarRec(NodoTexto actual, NodoTexto nuevo) {
        if (actual.getMenosVistoSiguiente() == null) {
            actual.setSiguienteMenosVisto(nuevo);
        } else {
            insertarRec(actual.getMenosVistoSiguiente(), nuevo);
        }
    }

    //Metodo que retorna el texto mas visto que no fue visto ni creado por el usuario
    public NodoTexto buscarTextoMasVisto(NodoArbolUsuarios usuario) {
        return buscarTextoMasVistoRec(primero, usuario);
    }

    private NodoTexto buscarTextoMasVistoRec(NodoTexto actual, NodoArbolUsuarios usuario) {
        NodoTexto encontrado = null;

        if (actual != null) {
            //Me fijo si el texto fue creado o visto por el usuario
            boolean esPropio = validarTexto(actual.getTexto(), usuario.getTextosCreados());
            boolean yaVisto = validarTextoVisto(actual.getTexto(), usuario.getTextosVisto());

            if (!esPropio && !yaVisto) {
                encontrado = actual; // este texto sirve
            } else {
                encontrado = buscarTextoMasVistoRec(actual.getMenosVistoSiguiente(), usuario);
            }
        }

        return encontrado;
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

    public boolean validarTextoVisto(String texto, NodoVisto primeroVisto) {
        return validarTextoRecVisto(primeroVisto, texto);
        
    }
    private boolean validarTextoRecVisto(NodoVisto actual, String texto) {
        boolean existeTexto = false; //Variable que me sirve para poder retornar si el texto se encontro o no
        if(actual != null) {
            //Si el texto del nodo actual es igual al texto 
            if (actual.getTextoVisto().getTexto().equals(texto)) {  
                existeTexto = true;
            }else{
                //de lo contrario sigo recorriendo 
                existeTexto = validarTextoRecVisto(actual.getVistoSiguiente(),texto);
            }
        }
        return existeTexto; //Si no encontro un texto igual deberia retornar false
    }

    //Reordena la lista si el texto actualizado cambió su cantidad de vistas (lo "elimina" y lo vuelve a insertar en la posición correspondiente)
    public void reordenarSiEsNecesario(NodoTexto textoActualizado) {
        if (primero != null && textoActualizado != null) {
            if (textoActualizado != primero) {
                eliminar(textoActualizado);
                insertarOrdenado(textoActualizado);
            }
        }
    }

    private void eliminar(NodoTexto eliminar) {
        if (primero != null) {
            if (primero == eliminar) {
                primero = primero.getMenosVistoSiguiente();
            } else {
                eliminarRec(primero, eliminar);
            }
        }
    }

    // Elimina el nodo indicado de la lista
    private void eliminarRec(NodoTexto actual, NodoTexto eliminar){
        if (actual.getMenosVistoSiguiente() != null) {
            if (actual.getMenosVistoSiguiente() == eliminar){
                actual.setMenosVistoSiguiente(eliminar.getMenosVistoSiguiente());
            } else {
                eliminarRec(actual.getMenosVistoSiguiente(), eliminar);
            }
        }
    }

    private void insertarOrdenado(NodoTexto nuevo) {
        // Caso 1: lista vacía o el nuevo debe ir al principio
        if (primero == null || nuevo.getVistas() > primero.getVistas()) {
            nuevo.setMenosVistoSiguiente(primero);
            primero = nuevo;
        } else {
            insertarOrdenadoRec(primero, nuevo);
        }
    }

    private void insertarOrdenadoRec(NodoTexto actual, NodoTexto nuevo) {
        if (actual.getMenosVistoSiguiente() == null || nuevo.getVistas() > actual.getMenosVistoSiguiente().getVistas()) {

            nuevo.setMenosVistoSiguiente(actual.getMenosVistoSiguiente());
            actual.setMenosVistoSiguiente(nuevo);
        } else {
            insertarOrdenadoRec(actual.getMenosVistoSiguiente(), nuevo);
        }
    }










}
