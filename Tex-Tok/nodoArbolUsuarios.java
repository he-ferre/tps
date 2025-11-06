class nodoArbolUsuarios{

    private String nick;
    private int password;
    private nodoTexto textosCreados;
    private nodoVisto textosVistos;
    private nodoArbolUsuarios anterior;
    private nodoArbolUsuarios siguiente;

    public nodoArbolUsuarios(String nick, int password){
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
    }public nodoArbolUsuarios getAnterior(){
        return anterior;
    }
    public void setAnterior(nodoArbolUsuarios anterior){
        this.anterior = anterior;
    }
    public nodoArbolUsuarios getSiguiente(){
        return siguiente;
    }
    public void setSiguiente(nodoArbolUsuarios siguiente){
        this.siguiente = siguiente;
    }
    public nodoTexto getTextosCreados(){// Es solo una referencia al primero creado
        return textosCreados;
    }
    public nodoVisto getTextosVisto(){// es solo una referencia al primero visto , el cual tiene una referencia a nodoTexto
        return textosVistos;
    }

}