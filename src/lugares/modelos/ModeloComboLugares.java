package lugares.modelos;

import javax.swing.DefaultComboBoxModel;

public class ModeloComboLugares extends DefaultComboBoxModel{
private GestorLugares gl = GestorLugares.crear();
        
    public ModeloComboLugares() {
        for (Lugar lugar : gl.verLugares()) {
            this.addElement(lugar.verNombre());
        }
    }
    
    public Lugar obtenerLugar() {
        return (Lugar)this.getSelectedItem();
    }
    
    public void seleccionarLugar (Lugar lugar) {
        this.setSelectedItem(lugar);
    }
}
