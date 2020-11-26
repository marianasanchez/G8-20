package autores.controladores;

import autores.vistas.VentanaMensajeAutor;

public class ControladorMensajeAutor {
    private VentanaMensajeAutor ventana;
    
    public ControladorMensajeAutor(String mensaje) {
        this.ventana = new VentanaMensajeAutor(this);
        this.ventana.setMensaje(mensaje);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }
}
