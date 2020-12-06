package publicaciones.controladores;

import interfaces.IControladorPublicaciones;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import publicaciones.modelos.GestorPublicaciones;
import publicaciones.modelos.ModeloTablaPublicaciones;
import publicaciones.vistas.VentanaPublicaciones;

public class ControladorPublicaciones implements IControladorPublicaciones{

    private VentanaPublicaciones ventana;
    private GestorPublicaciones gp = new GestorPublicaciones().crear();
    
    public ControladorPublicaciones (JFrame padre, boolean modal){
        this.ventana = new VentanaPublicaciones(padre, modal, this);
        this.ventana.publicacionesCargadas();
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
        this.actualizar();
    }
    
    @Override
    public void btnNuevaClic(ActionEvent evt) {
       ControladorAMPublicacion controlador = new ControladorAMPublicacion("Nueva Publicacion", true, true, this.ventana, true);
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
//      ControladorAMPublicacion controlador = new ControladorAMPublicacion("Modificar Publicacion", false, false, this.ventana.verPublicacion(), this.ventana, true);
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        gp.borrarPublicacion(this.ventana.getPublicacion());
        this.actualizar();
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.ventana.setVisible(false);
        this.ventana.dispose();
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        ModeloTablaPublicaciones mtp = (ModeloTablaPublicaciones)this.ventana.getTablaPublicaciones().getModel();
        mtp.BuscarPublicaciones(this.ventana.getBusquedaPublicaciones());
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        this.actualizar();
    }

    @Override
    public void txtTituloPresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isLetter(c) || !Character.isDigit(c)) {
            switch(c) {
                case KeyEvent.VK_ENTER:    
                   this.btnBuscarClic(null);
                case KeyEvent.VK_BACK_SPACE:
                case KeyEvent.VK_SPACE:
                case KeyEvent.VK_DELETE:
                    break;
                default:                    
                    evt.consume();
                    break;
            }
        }
    }
    
    public void actualizar(){
        ModeloTablaPublicaciones mtp = (ModeloTablaPublicaciones)this.ventana.getTablaPublicaciones().getModel();
        mtp.actualizar();
        this.ventana.publicacionesCargadas();
    }
    
}
