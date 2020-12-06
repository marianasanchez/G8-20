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

/**
 *
 * @author Carlos
 */
class ControladorAMGrupo implements IControladorAMGrupo{
    private VentanaAMGrupo ventana;
    private GestorGrupos gg = GestorGrupos.crear();
    private boolean crear;
    private Grupo grupoAux;
    
    public ControladorAMGrupo(String title, boolean dniEnabled, boolean crear, JDialog padre, boolean modal) {
        this.crear = crear;
        this.ventana = new VentanaAMGrupo(padre, modal, this);
        this.ventana.setTitle(title);
//        this.ventana.dniEnabled(dniEnabled);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }
    
    public ControladorAMGrupo(String title, boolean dniEnabled, boolean crear, Grupo grupo, JDialog padre, boolean modal){
        this.crear = crear;
        this.ventana = new VentanaAMGrupo(padre, modal, this);
        this.ventana.setTitle(title);
//        this.ventana.dniEnabled(dniEnabled);
//        this.ventana.setDni(String.valueOf(autor.verDni()));
//        this.ventana.setApellidos(autor.verApellidos());
//        this.ventana.setNombres(autor.verNombres());
//        Profesor aux = (Profesor)autor;
//        this.ventana.setCargo(aux.verCargo());
//        this.ventana.setClave(autor.verClave());
//        this.ventana.setClaveRepetida(autor.verClave());
//        this.publicacionAux = autor;
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnModificarMiembrosClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
