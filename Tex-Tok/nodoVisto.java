public class nodoVisto {
    private nodoTexto textoVisto;
    private nodoVisto sigVisto;

    public nodoVisto(){
        this.textoVisto = null;
        this.sigVisto = null;
    }

    public nodoTexto getTextoVisto(){
        return textoVisto;
    }
    public void setTextoVisto(nodoTexto textoVisto){
        this.textoVisto = textoVisto;
    }
    public nodoVisto getSigVisto(){
        return sigVisto;
    }
    public void setSigVisto(nodoVisto sigVisto){
        this.sigVisto = sigVisto;
    }
}
