package autores.controladores;

import autores.modelos.GestorAutores;
import autores.vistas.VentanaConfirmarBorrarAutor;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import publicaciones.controladores.ControladorMensaje;
import interfaces.IControladorConfirmarBorrarAutor;

public class ControladorConfirmarBorrarAutor implements IControladorConfirmarBorrarAutor{

    private VentanaConfirmarBorrarAutor ventana;
    private GestorAutores ga = GestorAutores.crear();
    private int dniAutor;
    
    public ControladorConfirmarBorrarAutor (JDialog padre, boolean modal, int dni){
        this.ventana = new VentanaConfirmarBorrarAutor(padre, modal, this);
        this.dniAutor = dni;
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }
    
    @Override
    public void btnSiClic(ActionEvent evt) {
        String mensaje = ga.borrarAutor(ga.verAutor(dniAutor));
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
