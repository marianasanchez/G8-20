package tipos.modelos;

import lugares.modelos.*;
import idiomas.modelos.*;
import grupos.modelos.*;
import autores.modelos.*;
import javax.swing.DefaultComboBoxModel;

public class ModeloComboTipos extends DefaultComboBoxModel{
private GestorTipos gt = GestorTipos.crear();
        
    public ModeloComboTipos() {
        for (Tipo tipo : gt.verTipos()) {
            this.addElement(tipo.verNombre());
        }
    }
    
    public Tipo obtenerTipo() {
        return (Tipo)this.getSelectedItem();
    }
    
    public void seleccionarTipo (Tipo tipo) {
        this.setSelectedItem(tipo);
    }
}
