
package servidorreloj;

import java.util.Date;

public class Servidor {
    
    private Date horaActual;
    
    public Servidor(){
        horaActual = new Date();
    }

    public Date getHoraActual() {
        return horaActual;
    }

    public void setHoraActual(Date horaActual) {
        this.horaActual = horaActual;
    }
    
    public Date cambiarHoraActual() throws InterruptedException{
        this.horaActual.setTime(this.horaActual.getTime() + 1010);
        Thread.sleep(1000);
        return this.horaActual;
    }
    
}
