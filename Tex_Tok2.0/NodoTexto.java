import java.io.Serializable;
import java.time.LocalDate;

class NodoTexto implements Serializable{

    private static final long serialVersionUID = 1L;

    private LocalDate fecha;  // Esta bien asi?
    private String texto;
    private int vistas;
    private NodoTexto siguiente; // se relaciona con los textos creados por el usuario
    private NodoTexto menosVistoSiguiente; // se relaciona con la cantidad de vistas(hace la lista textosMasVistos);

    public NodoTexto(String texto, LocalDate fecharDate){
        this.fecha = fecharDate; // puedo poner aca mismo que utilice la libreria date?
        this.texto = texto;
        this.vistas = 0;
        this.siguiente = null;
        this.menosVistoSiguiente = null;
    }


// faltan getters y setters 

    public void setSiguiente(NodoTexto siguiente){
        this.siguiente = siguiente;
    }
    public NodoTexto getSiguiente(){
        return siguiente;
    }
    public NodoTexto getMenosVistoSiguiente(){  // Esto esta bien?
        return menosVistoSiguiente;
    }
    public void setSiguienteMenosVisto(NodoTexto nuevo){
        this.menosVistoSiguiente = nuevo ;
    }
    public String getTexto(){
        return texto;
    }
    public LocalDate getFecha(){
        return fecha;
    }
    public int getVistas(){
        return vistas;
    }
    public void sumarVista() {
        this.vistas++;
    }
    public void setMenosVistoSiguiente(NodoTexto menosVistoSiguiente) {
        this.menosVistoSiguiente = menosVistoSiguiente;
    }

}