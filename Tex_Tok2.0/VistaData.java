import java.io.Serializable;

public class VistaData implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nickAutor;
    private String texto;
    private String nickLector;

    public VistaData(String nickAutor, String texto, String nickLector){
        this.nickAutor = nickAutor;       
        this.texto = texto;
        this.nickLector = nickLector;
    }
    public String getNickCreador() {
        return nickAutor; }
    public String getTexto() { 
        return texto; }
    public String getNickLector() { 
        return nickLector; }
}
