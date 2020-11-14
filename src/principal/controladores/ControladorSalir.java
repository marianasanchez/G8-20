/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.controladores;

import java.awt.event.ActionEvent;
import principal.vistas.VentanaSalir;
import interfaces.IControladorSalir;

public class ControladorSalir implements IControladorSalir{

    private VentanaSalir ventana;
    
    public ControladorSalir() {
        this.ventana = new VentanaSalir(this);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }
    
    @Override
    public void btnConfirmarSalirClic(ActionEvent evt) {
        System.exit(0);
    }

    @Override
    public void btnCancelarSalirClic(ActionEvent evt) {
        this.ventana.setVisible(false);
        this.ventana.dispose();
    }
    
}
