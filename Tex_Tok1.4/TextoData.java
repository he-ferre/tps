import java.io.Serializable;
import java.time.LocalDate;

public class TextoData implements Serializable {
    private String nickAutor;
    private LocalDate fecha;
    private String texto;

    public TextoData(String nickAutor, LocalDate fecha, String texto){
        this.nickAutor = nickAutor;
        this.fecha = fecha;
        this.texto = texto;
    }


    public String getNick(){
        return nickAutor;
    }
    public LocalDate getFecha(){
        return fecha;
    }
    public String getTexto(){
        return texto;
    }
}
