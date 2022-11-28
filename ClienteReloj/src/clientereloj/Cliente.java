
package clientereloj;

import java.util.Date;

public class Cliente {
    
    private Date hora;
    private String nombre;
    
    public Cliente(){
        nombre = "Anonimo";
    }
    
    public Cliente(Date hora, String nombre){
        this.hora = hora;
        this.nombre = nombre;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre != null){
            this.nombre = nombre;
        }
    }
    
    public Date aumentarTiempo(){
        long miliSecond = this.hora.getTime() + 1000;
        this.hora.setTime(miliSecond);
        return this.hora;
    }
    
}
