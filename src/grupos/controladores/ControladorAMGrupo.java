/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.controladores;

import grupos.modelos.GestorGrupos;
import grupos.modelos.Grupo;
import grupos.vistas.VentanaAMGrupo;
import interfaces.IControladorAMGrupo;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import publicaciones.controladores.ControladorMensaje;

/**
 *
 * @author Carlos
 */
class ControladorAMGrupo implements IControladorAMGrupo{
    private VentanaAMGrupo ventana;
    private GestorGrupos gg = GestorGrupos.crear();
    private boolean crear;
    private Grupo grupoAux;
    
    public ControladorAMGrupo(String title, boolean modificarEnabled, JDialog padre, boolean modal) {
        this.crear = !modificarEnabled;
        this.ventana = new VentanaAMGrupo(padre, modal, this);
        this.ventana.setTitle(title);
        this.ventana.modificarEnabled(modificarEnabled, null);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }
    
    public ControladorAMGrupo(String title, boolean modificarEnabled, Grupo grupo, JDialog padre, boolean modal){
        this.crear = !modificarEnabled;
        this.ventana = new VentanaAMGrupo(padre, modal, this);
        this.ventana.setTitle(title);
        this.ventana.modificarEnabled(modificarEnabled, grupo);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        String mensaje;
        if(crear == true){
            mensaje = this.gg.nuevoGrupo(this.ventana.getNombre(), this.ventana.getDescripcion());
            if(mensaje.equals(gg.EXITO)){
                this.ventana.setVisible(false);
                this.ventana.dispose();
            }
        }
        else {
            mensaje = this.gg.modificarGrupo(gg.verGrupo(this.ventana.getNombre()), this.ventana.getDescripcion());
            if(mensaje.equals(gg.MODIFICADO)){
                this.ventana.setVisible(false);
                this.ventana.dispose();
            }
        }
        ControladorMensaje cont = new ControladorMensaje(this.ventana, true, mensaje);
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ventana.setVisible(false);
        this.ventana.dispose(); 
    }

    @Override
    public void btnModificarMiembrosClic(ActionEvent evt) {
        ControladorModificarMiembros controlador = new ControladorModificarMiembros(this.ventana, true, gg.verGrupo(this.ventana.getNombre()));
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
