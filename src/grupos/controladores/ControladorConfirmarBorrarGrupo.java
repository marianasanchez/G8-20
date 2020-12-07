package grupos.controladores;

import autores.controladores.*;
import autores.modelos.GestorAutores;
import autores.vistas.VentanaConfirmarBorrarAutor;
import grupos.modelos.GestorGrupos;
import grupos.vistas.VentanaConfirmarBorrarGrupo;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import publicaciones.controladores.ControladorMensaje;
import interfaces.IControladorConfirmarBorrarAutor;
import interfaces.IControladorConfirmarBorrarGrupo;

public class ControladorConfirmarBorrarGrupo implements IControladorConfirmarBorrarGrupo{

    private VentanaConfirmarBorrarGrupo ventana;
    private GestorGrupos gg = GestorGrupos.crear();
    private String nombreGrupo;
    
    public ControladorConfirmarBorrarGrupo (JDialog padre, boolean modal, String nombre){
        this.ventana = new VentanaConfirmarBorrarGrupo(padre, modal, this);
        this.nombreGrupo = nombre;
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }
    
    @Override
    public void btnSiClic(ActionEvent evt) {
        String mensaje = gg.borrarGrupo(gg.verGrupo(nombreGrupo));
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
