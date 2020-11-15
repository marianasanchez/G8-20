/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.controladores;

import autores.modelos.Autor;
import autores.modelos.GestorAutores;
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
    private boolean crear;
    private Autor autorAux;
    
    public ControladorAMProfesor(String title, boolean dniEnabled, boolean crear) {
        this.crear = crear;
        this.ventana = new VentanaAMProfesor(this);
        this.ventana.setTitle(title);
        this.ventana.dniEnabled(dniEnabled);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }
    
    public ControladorAMProfesor(String title, boolean dniEnabled, boolean crear, Autor autor){
        this.crear = crear;
        this.ventana = new VentanaAMProfesor(this);
        this.ventana.setTitle(title);
        this.ventana.dniEnabled(dniEnabled);
        this.ventana.setDni(String.valueOf(autor.verDni()));
        this.ventana.setApellidos(autor.verApellidos());
        this.ventana.setNombres(autor.verNombres());
        this.autorAux = autor;
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }
    
    @Override
    public void btnGuardarClic(ActionEvent evt) {
        if(crear == true){
            System.out.println(this.ga.nuevoAutor(this.ventana.getDni(), this.ventana.getApellidos(), this.ventana.getNombres(), this.ventana.getCargo(), this.ventana.getClave(), this.ventana.getClaveRepetida()));
        }
        else {
            System.out.println(autorAux.verDni());
            System.out.println(autorAux.verClave());
            System.out.println(this.ga.modificarAutor(autorAux, this.ventana.getApellidos(), this.ventana.getNombres(), this.ventana.getCargo(), this.ventana.getClave(), this.ventana.getClaveRepetida()));
        }
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
