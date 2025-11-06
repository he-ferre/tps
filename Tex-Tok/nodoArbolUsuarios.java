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

}