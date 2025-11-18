public class NodoVisto {
    private NodoTexto textoVisto;
    private NodoVisto MenosVistoSiguiente;

    public NodoVisto(NodoTexto textoVisto){
        this.textoVisto = textoVisto;
        this.MenosVistoSiguiente = null;
    }

    public NodoTexto getTextoVisto(){
        return textoVisto;
    }
    public void setTextoVisto(NodoTexto textoVisto){
        this.textoVisto = textoVisto;
    }
    public NodoVisto getSigVisto(){
        return MenosVistoSiguiente;
    }
}

