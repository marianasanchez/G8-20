package autores.controladores;

import autores.modelos.Autor;
import autores.modelos.GestorAutores;
import autores.modelos.Profesor;
import autores.vistas.VentanaAMProfesor;
import interfaces.IControladorAMProfesor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import publicaciones.controladores.ControladorMensaje;

public class ControladorAMProfesor implements IControladorAMProfesor{

    private VentanaAMProfesor ventana;
    private GestorAutores ga = GestorAutores.crear();
    private boolean crear;
    private Autor autorAux;
    
    public ControladorAMProfesor(String title, boolean dniEnabled, boolean crear, JDialog padre, boolean modal) {
        this.crear = crear;
        this.ventana = new VentanaAMProfesor(padre, modal, this, false, null);
        this.ventana.setTitle(title);
        this.ventana.dniEnabled(dniEnabled);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }
    
    public ControladorAMProfesor(String title, boolean dniEnabled, boolean crear, Autor autor, JDialog padre, boolean modal){
        this.crear = crear;
        this.ventana = new VentanaAMProfesor(padre, modal, this, true, autor);
        this.ventana.setTitle(title);
        this.ventana.dniEnabled(dniEnabled);
        this.ventana.setDni(String.valueOf(autor.verDni()));
        this.ventana.setApellidos(autor.verApellidos());
        this.ventana.setNombres(autor.verNombres());
        Profesor aux = (Profesor)autor;
        this.ventana.setCargo(aux.verCargo());
        this.ventana.setClave(autor.verClave());
        this.ventana.setClaveRepetida(autor.verClave());
        this.autorAux = autor;
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }
    
    @Override
    public void btnGuardarClic(ActionEvent evt) {
        String mensaje;
        if(crear == true){
            mensaje = this.ga.nuevoAutor(this.ventana.getDni(), this.ventana.getApellidos(), this.ventana.getNombres(), this.ventana.getCargo(), this.ventana.getClave(), this.ventana.getClaveRepetida());
            if(mensaje.equals(ga.EXITO)){
                this.ventana.setVisible(false);
                this.ventana.dispose();
            }
        }
        else {
            mensaje = this.ga.modificarAutor(autorAux, this.ventana.getApellidos(), this.ventana.getNombres(), this.ventana.getCargo(), this.ventana.getClave(), this.ventana.getClaveRepetida());
            if(mensaje.equals(ga.MODIFICADO)){
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
    public void txtApellidosPresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isLetter(c)) {
            switch(c) {
                case KeyEvent.VK_ENTER:   
                    this.btnGuardarClic(null);              
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

    @Override
    public void txtNombresPresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isLetter(c)) {
            switch(c) {            
                case KeyEvent.VK_ENTER:   
                    this.btnGuardarClic(null);
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

    @Override
    public void txtDocumentoPresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            switch(c) {
                case KeyEvent.VK_ENTER: 
                    this.btnGuardarClic(null);               
                case KeyEvent.VK_BACK_SPACE:
                case KeyEvent.VK_DELETE:
                    break;
                default:
                    evt.consume();
                    break;
            }
        }
    }

    @Override
    public void passClavePresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isAlphabetic(c) & !Character.isDigit(c)) {
            switch(c) {
                case KeyEvent.VK_ENTER:   
                    this.btnGuardarClic(null);             
                case KeyEvent.VK_BACK_SPACE:
                case KeyEvent.VK_DELETE:
                    break;
                default:
                    evt.consume();
                    break;
            }
        }  
    }

    @Override
    public void passRepetirClavePresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isAlphabetic(c) & !Character.isDigit(c)) {
            switch(c) {
                case KeyEvent.VK_ENTER:    
                    this.btnGuardarClic(null);            
                case KeyEvent.VK_BACK_SPACE:
                case KeyEvent.VK_DELETE:
                    break;
                default:
                    evt.consume();
                    break;
            }
        }  
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}