/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

import autores.vistas.VentanaAMAutores;
import interfaces.IControladorAutores;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

/**
 *
 * @author Carlos
 */
public class ControladorAutores implements IControladorAutores {
    private VentanaAMAutores ventana;
    private GestorAutores ga = GestorAutores.crear();
    
    public ControladorAutores() {
        this.ventana = new VentanaAMAutores(this);
        this.ventana.autoresCargados();
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
        this.actualizar();
    }
    
    @Override
    public void btnNuevoProfesorClic(ActionEvent evt) {
        ControladorAMProfesor controlador = new ControladorAMProfesor("Nuevo Profesor", true, true);
        this.ventana.setVisible(false);
        this.ventana.dispose();
    }

    @Override
    public void btnNuevoAlumnoClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnModificarProfesorClic(ActionEvent evt) {
        ControladorAMProfesor controlador = new ControladorAMProfesor("Modificar Profesor", false, false, this.ventana.verProfesor());
        System.out.println(this.ventana.verProfesor());
        this.ventana.setVisible(false);
        this.ventana.dispose();
    }

    @Override
    public void btnModificarAlumnoClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnBorrarProfesorClic(ActionEvent evt) {
        ga.BorrarAutor(this.ventana.verDniProfesor());
        ModeloTablaProfesores mtp = (ModeloTablaProfesores)this.ventana.getTablaProfesores().getModel();
        mtp.actualizar();
    }

    @Override
    public void btnBorrarAlumnoClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnBuscarProfesorClic(ActionEvent evt) {
        
    }

    @Override
    public void btnBuscarAlumnoClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void txtApellidosProfesorPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void txtApellidosAlumnoPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void actualizar(){
        ModeloTablaProfesores mtp = (ModeloTablaProfesores)this.ventana.getTablaProfesores().getModel();
        mtp.actualizar();
    }
}
