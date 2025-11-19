import java.io.Serializable;

public class VistaData implements Serializable {
    private String nickAutor;
    private String texto;
    private String nickLector;

    public VistaData(String nickAutor, String texto, String nickLector){
        this.nickAutor = nickAutor;       
        this.texto = texto;
        this.nickLector = nickLector;
    }
}
