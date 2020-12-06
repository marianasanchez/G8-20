package grupos.controladores;

import grupos.modelos.GestorGrupos;
import grupos.modelos.ModeloTablaGrupos;
import grupos.vistas.VentanaGrupos;
import interfaces.IControladorGrupos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class ControladorGrupos implements IControladorGrupos{
    
    private VentanaGrupos ventana;
    private GestorGrupos gg = new GestorGrupos().crear();
    
    public ControladorGrupos (JFrame padre, boolean modal) {
        this.ventana = new VentanaGrupos(padre, modal, this);
        this.ventana.gruposCargados();
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
        this.actualizar();
    }
    
    @Override
    public void btnNuevoClic(ActionEvent evt) {
    ControladorAMGrupo controlador = new ControladorAMGrupo("Nuevo Profesor", true, true, this.ventana, true);
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        gg.borrarGrupo(this.ventana.getGrupo());
        this.actualizar();
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.ventana.setVisible(false);
        this.ventana.dispose();
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        ModeloTablaGrupos mtg = (ModeloTablaGrupos)this.ventana.getTablaGrupos().getModel();
        mtg.BuscarGrupos(this.ventana.getBusquedaGrupos());
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        this.actualizar();
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
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
        ModeloTablaGrupos mtg = (ModeloTablaGrupos)this.ventana.getTablaGrupos().getModel();
        mtg.actualizar();
        this.ventana.gruposCargados();
    }
}
