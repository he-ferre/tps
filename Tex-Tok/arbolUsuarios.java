class arbolUsuarios{
    private nodoArbolUsuarios raiz;

    public arbolUsuarios(){
        this.raiz = null;
    }

    public nodoArbolUsuarios buscarUsuario(String nick){
        // TODO: implementar la busqueda binaria
        nodoArbolUsuarios usuario = null;
        return usuario;
    }

    public void agregarUsuario(String nick, int password){
        //TODO: hacer logica de agregado
    }


    public nodoArbolUsuarios getRaiz(){
        return raiz;
    }
    public void setRaiz(nodoArbolUsuarios raiz){
        this.raiz = raiz;
    }
}