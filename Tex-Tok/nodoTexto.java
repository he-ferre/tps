import java.time.LocalDate;

class nodoTexto{
    private LocalDate fecha;  // Esta bien asi?
    private String texto;
    private int vistas;
    private nodoTexto siguiente; // se relaciona con los textos creados por el usuario
    private nodoTexto menosVistoSiguiente; // se relaciona con la cantidad de vistas(hace la lista textosMasVistos);

    public nodoTexto(String texto){
        this.fecha = LocalDate.now(); // puedo poner aca mismo que utilice la libreria date?
        this.texto = texto;
        this.vistas = 0;
        this.siguiente = null;
        this.menosVistoSiguiente = null;
    }

    public void setSiguiente(nodoTexto siguiente){
        this.siguiente = siguiente;
    }
}
