/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

import autores.vistas.VentanaAMAutores;
import autores.vistas.VentanaAMProfesor;
import interfaces.IControladorAMProfesor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 *
 * @author rodrigo
 */
public class ControladorAMProfesor implements IControladorAMProfesor{

    private VentanaAMProfesor ventana;
    private GestorAutores ga = GestorAutores.crear();
    
    public ControladorAMProfesor(String title, boolean dniEnabled) {
        this.ventana = new VentanaAMProfesor(this);
        this.ventana.setTitle(title);
        this.ventana.dniEnabled(dniEnabled);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }
    
    @Override
    public void btnGuardarClic(ActionEvent evt) {
        System.out.println(this.ga.nuevoAutor(this.ventana.getDni(), this.ventana.getApellidos(), this.ventana.getNombres(), this.ventana.getCargo(), this.ventana.getClave(), this.ventana.getClaveRepetida()));
//        System.out.println("Listilla de profs: " + ga.verProfesores());
        ControladorAutores controlador = new ControladorAutores();
        this.ventana.setVisible(false);
        this.ventana.dispose();
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        ControladorAutores controlador = new ControladorAutores();
        this.ventana.setVisible(false);
        this.ventana.dispose();    
    }

    @Override
    public void txtApellidosPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void txtNombresPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void txtDocumentoPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void passClavePresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void passRepetirClavePresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
