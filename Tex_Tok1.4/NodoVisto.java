import java.io.Serializable;


public class NodoVisto implements Serializable{

    private static final long serialVersionUID = 1L;

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

