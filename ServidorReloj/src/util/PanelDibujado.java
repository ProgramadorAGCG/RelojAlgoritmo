
package util;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelDibujado extends JPanel{
    
    private Image imagen;
    private final String url;
    
    public PanelDibujado(String url){
        this.url = url;
    }
    
    @Override
    public void paint(Graphics g){
        imagen = new ImageIcon(getClass().getResource(url)).getImage();
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
    
}
