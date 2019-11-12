
package Modelos;


public class Usuario {
    
    private int cantidad=0;
    public int getcantidad(){
        return this.cantidad;
    }
    public void setcantidad(){
        this.cantidad=getcantidad()+1;
    }
    public void iniciar(){
        this.cantidad=0;
    }
}
