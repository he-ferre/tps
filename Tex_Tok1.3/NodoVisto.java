public class NodoVisto {
    private NodoTexto textoVisto;
    private NodoVisto vistoSiguiente;

    public NodoVisto(NodoTexto textoVisto){
        this.textoVisto = textoVisto;
        this.vistoSiguiente = null;
    }

    public NodoTexto getTextoVisto(){
        return textoVisto;
    }
    public void setTextoVisto(NodoTexto textoVisto){
        this.textoVisto = textoVisto;
    }
    public NodoVisto getVistoSiguiente(){
        return vistoSiguiente;
    }
    public void setVistoSiguiente(NodoVisto n){
        this.vistoSiguiente = n;
    }
}

