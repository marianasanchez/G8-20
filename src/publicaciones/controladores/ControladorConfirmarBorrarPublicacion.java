package publicaciones.controladores;

import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import interfaces.IControladorConfirmarBorrarPublicacion;
import publicaciones.modelos.GestorPublicaciones;
import publicaciones.vistas.VentanaConfirmarBorrarPublicacion;

public class ControladorConfirmarBorrarPublicacion implements IControladorConfirmarBorrarPublicacion{

    private VentanaConfirmarBorrarPublicacion ventana;
    private GestorPublicaciones gp = GestorPublicaciones.crear();
    private String titulo;
    
    public ControladorConfirmarBorrarPublicacion (JDialog padre, boolean modal, String titulo){
        this.ventana = new VentanaConfirmarBorrarPublicacion(padre, modal, this);
        this.titulo = titulo;
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }
    
    @Override
    public void btnSiClic(ActionEvent evt) {
        String mensaje = gp.borrarPublicacion(gp.verPublicacion(titulo));
        ControladorMensaje cont = new ControladorMensaje(this.ventana, true, mensaje);
        this.ventana.setVisible(false);
        this.ventana.dispose();
    }

    @Override
    public void btnNoClic(ActionEvent evt) {
        this.ventana.setVisible(false);
        this.ventana.dispose();
    }
}
