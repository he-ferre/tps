class NodoArbolUsuarios{

    private String nick;
    private int password;
    private NodoTexto textosCreados;
    private NodoVisto textosVistos;
    private NodoArbolUsuarios anterior;
    private NodoArbolUsuarios siguiente;

    public NodoArbolUsuarios(String nick, int password){
        this.nick = nick;
        this.password = password;
        this.textosCreados = null; // inicialmente no crea ningun texto;
        this.textosVistos = null;// inicialmente no ve ningun texto;
        this.anterior = null;
        this.siguiente = null;
    }

    public String getNick(){
        return nick;
    }
    public void setNick(String nick){
        this.nick = nick;
    }
    public int getPassword(){
        return password;
    }
    public void setPassword(int password){
        this.password = password;
    }
    public NodoArbolUsuarios getAnterior(){
        return anterior;
    }
    public void setAnterior(NodoArbolUsuarios anterior){
        this.anterior = anterior;
    }
    public NodoArbolUsuarios getSiguiente(){
        return siguiente;
    }
    public void setSiguiente(NodoArbolUsuarios siguiente){
        this.siguiente = siguiente;
    }
    public NodoTexto getTextosCreados(){// Es solo una referencia al primero creado
        return textosCreados;
    }
    public NodoVisto getTextosVisto(){// es solo una referencia al primero visto , el cual tiene una referencia a nodoTexto
        return textosVistos;
    }
    public void setTextosCreados(NodoTexto nuevoTexto){
        this.textosCreados = nuevoTexto;
    }
    public void setTextosVistos(NodoVisto n) {
        this.textosVistos = n;
    }



}
