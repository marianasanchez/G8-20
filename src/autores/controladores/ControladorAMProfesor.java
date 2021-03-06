package autores.controladores;

import autores.modelos.Autor;
import autores.modelos.GestorAutores;
import autores.vistas.VentanaAMProfesor;
import interfaces.IControladorAMProfesor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

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
        String mensaje;
        if(crear == true){
            mensaje = this.ga.nuevoAutor(this.ventana.getDni(), this.ventana.getApellidos(), this.ventana.getNombres(), this.ventana.getCargo(), this.ventana.getClave(), this.ventana.getClaveRepetida());
        }
        else {
            mensaje = this.ga.modificarAutor(autorAux, this.ventana.getApellidos(), this.ventana.getNombres(), this.ventana.getCargo(), this.ventana.getClave(), this.ventana.getClaveRepetida());
        }
        ControladorAutores controlador = new ControladorAutores();
        ControladorMensajeAutor cont = new ControladorMensajeAutor(mensaje);
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
        char c = evt.getKeyChar();
        if (!Character.isLetter(c)) {
            switch(c) {
                case KeyEvent.VK_ENTER:                
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
                case KeyEvent.VK_BACK_SPACE:
                case KeyEvent.VK_DELETE:
                    break;
                default:
                    evt.consume();
                    break;
            }
        }  
    }
}
