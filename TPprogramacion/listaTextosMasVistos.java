class listaTextosMasVistos{
    private nodoTexto primero;
    //se relaciona con el atributo menosVistoSiguiente;
    public listaTextosMasVistos(){
        this.primero = null;
    }

    public nodoTexto getPrimeroMasVistos(){
        return primero;
    }
    public void setPrimeroMasVistos(nodoTexto primeroMasVistos){
        this.primero = primeroMasVistos;
    }
}