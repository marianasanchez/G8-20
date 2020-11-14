package principal.controladores;

import interfaces.IControladorPrincipal;
import java.awt.event.ActionEvent;
import principal.vistas.VentanaPrincipal;
import principal.vistas.VentanaSalir;

public class ControladorPrincipal implements IControladorPrincipal{
    
    private VentanaPrincipal ventana;
    
    public ControladorPrincipal() {
        this.ventana = new VentanaPrincipal(this);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }
    
    @Override
    public void btnAutoresClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnSalirClic(ActionEvent evt) {
        ControladorSalir salir = new ControladorSalir();
    }
}

