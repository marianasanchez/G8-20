/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.controladores;

import interfaces.IControladorAMPublicacion;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JDialog;
import publicaciones.modelos.GestorPublicaciones;
import publicaciones.modelos.Publicacion;
import publicaciones.vistas.VentanaAMPublicacion;

/**
 *
 * @author Carlos
 */
class ControladorAMPublicacion implements IControladorAMPublicacion {
    private VentanaAMPublicacion ventana;
    private GestorPublicaciones gp = GestorPublicaciones.crear();
    private boolean crear;
    private Publicacion publicacionAux;
    
    public ControladorAMPublicacion(String title, boolean dniEnabled, boolean crear, JDialog padre, boolean modal) {
        this.crear = crear;
        this.ventana = new VentanaAMPublicacion(padre, modal, this);
        this.ventana.setTitle(title);
//        this.ventana.dniEnabled(dniEnabled);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }
    
    public ControladorAMPublicacion(String title, boolean dniEnabled, boolean crear, Publicacion publicacion, JDialog padre, boolean modal){
        this.crear = crear;
        this.ventana = new VentanaAMPublicacion(padre, modal, this);
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
    public void txtTituloPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnTodasLasPalabrasClavesClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnNingunaPalabraClaveClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnAbrirClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
