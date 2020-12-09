package idiomas.modelos;

import grupos.modelos.*;
import autores.modelos.*;
import javax.swing.DefaultComboBoxModel;

public class ModeloComboIdiomas extends DefaultComboBoxModel{
private GestorIdiomas gi = GestorIdiomas.crear();
        
    public ModeloComboIdiomas() {
        for (Idioma idioma : gi.verIdiomas()) {
            this.addElement(idioma.verNombre());
        }
    }
    
    public Idioma obtenerIdioma() {
        return (Idioma)this.getSelectedItem();
    }
    
    public void seleccionarIdioma (Idioma idioma) {
        this.setSelectedItem(idioma);
    }
}
