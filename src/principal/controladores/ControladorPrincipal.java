package principal.controladores;

//<editor-fold defaultstate="collapsed" desc="Traajo Práctico N° 7">
//Parcial N° 1
//package principal.controladores;

import autores.controladores.ControladorAutores;
import idiomas.controladores.ControladorIdiomas;
import interfaces.IControladorPrincipal;
import java.awt.event.ActionEvent;
import principal.vistas.VentanaPrincipal;

public class ControladorPrincipal implements IControladorPrincipal{
    
    private VentanaPrincipal ventana;
    
    public ControladorPrincipal() {
        this.ventana = new VentanaPrincipal(this);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }
    
    @Override
    public void btnAutoresClic(ActionEvent evt) {
        ControladorAutores autores = new ControladorAutores(this.ventana, true);
    }

    @Override
    public void btnSalirClic(ActionEvent evt) {
        ControladorSalir salir = new ControladorSalir(this.ventana, true);
    }

    @Override
    public void btnIdiomasClic(ActionEvent evt) {
        ControladorIdiomas idiomas = new ControladorIdiomas(this.ventana, true);
    }
}
//</editor-fold>