
import java.io.Serializable;

public class UsuarioData implements Serializable{

    private static final long serialVersionUID = 1L;

    private String nick;
    private int password;

    public UsuarioData(String nick, int password){
        this.nick = nick;
        this.password = password;
    }

    public String getNick(){
        return nick;
    }
    public int getPassword(){
        return password;
    }
}
