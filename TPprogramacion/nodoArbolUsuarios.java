class nodoArbolUsuarios{

    private String nick;
    private int password;
    private listaTextosCreados textosCreados; // lista con referencia a nodos
    private listaVistos textosVistos; // lista con referencia a nodos
    private nodoArbolUsuarios anterior;
    private nodoArbolUsuarios siguiente;

    public nodoArbolUsuarios(String nick, int password){
        this.nick = nick;
        this.password = password;
        this.textosCreados = new listaTextosCreados();
        this.textosVistos = new listaVistos();
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
    public nodoArbolUsuarios getAnterior(){
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

}