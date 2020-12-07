package publicaciones.controladores;

import javax.swing.JDialog;
import principal.vistas.VentanaMensaje;

public class ControladorMensaje {
    private VentanaMensaje ventana;
    
    public ControladorMensaje(JDialog padre, boolean modal, String mensaje) {
        this.ventana = new VentanaMensaje(padre, modal, this);
        this.ventana.setMensaje(mensaje);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }
}
