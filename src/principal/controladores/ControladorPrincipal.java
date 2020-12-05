//<editor-fold defaultstate="collapsed" desc="Parcial N° 2">
package principal.controladores;

import autores.controladores.ControladorAutores;
import grupos.controladores.ControladorGrupos;
import interfaces.IControladorPrincipal;
import java.awt.event.ActionEvent;
import principal.vistas.VentanaPrincipal;
import publicaciones.controladores.ControladorPublicaciones;

public class ControladorPrincipal implements IControladorPrincipal{
    
    private VentanaPrincipal ventana;
    
    public ControladorPrincipal() {
        this.ventana = new VentanaPrincipal(this);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }
    
    @Override
    public void btnGruposClic(ActionEvent evt) {
        ControladorGrupos grupos = new ControladorGrupos(this.ventana, true);
    }
    
    @Override
    public void btnAutoresClic(ActionEvent evt) {
        ControladorAutores autores = new ControladorAutores(this.ventana, true);
    }
    
    @Override
    public void btnPublicacionesClic(ActionEvent evt) {
        ControladorPublicaciones publicaciones = new ControladorPublicaciones(this.ventana, true);
    }

    @Override
    public void btnSalirClic(ActionEvent evt) {
        ControladorSalir salir = new ControladorSalir(this.ventana, true);
    }
    
    

    @Override
    public void btnPalabrasClavesClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnLugaresClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnIdiomasClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnTiposClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
}
//</editor-fold>