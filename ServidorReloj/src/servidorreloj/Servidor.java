
package servidorreloj;

import java.util.Date;

public class Servidor {
    
    private long horaActual;
    
    public Servidor(){
        horaActual = System.currentTimeMillis();
    }

    public long getHoraActual() {
        return horaActual;
    }

    public void setHoraActual(long horaActual) {
        this.horaActual = horaActual;
    }
    
    public Date cambiarHoraActual(){
        return new Date(horaActual = System.currentTimeMillis());
    }
    
}
