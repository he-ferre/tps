public class textosMasVistos {
    private nodoTexto primero;

    public textosMasVistos(){
        this.primero = null;
    }

    public nodoTexto getPrimero(){ 
        return primero;
    }
    public void setPrimero(nodoTexto primero){ // Este depende de las vistas , entonces puede cambiar
        this.primero = primero;
    }
}
