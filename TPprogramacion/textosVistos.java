class listaVistos{
    private nodoTexto primeroVistos;
    //referencia a todos los textos vistos por el usuario 
    public listaVistos(){
        this.primeroVistos = null;
    }

    public nodoTexto getPrimeroVistos(){
        return primeroVistos;
    }
    public void setPrimeroVistos(nodoTexto primeroVistos){
        this.primeroVistos = primeroVistos;
    }
}