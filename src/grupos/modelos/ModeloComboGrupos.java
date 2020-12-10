package grupos.modelos;

import autores.modelos.Autor;
import javax.swing.DefaultComboBoxModel;

public class ModeloComboGrupos extends DefaultComboBoxModel{
private GestorGrupos gg = GestorGrupos.crear();
        
    public ModeloComboGrupos() {
        for (Grupo grupo : gg.verGrupos()) {
            this.addElement(grupo.verNombre());
        }
    }
    
    public ModeloComboGrupos(Autor autor) {
        for (Grupo grupo : autor.mostrarGrupos()) {
            this.addElement(grupo.verNombre());
        }
    }
    
    public Grupo obtenerGrupo() {
        return (Grupo)this.getSelectedItem();
    }
    
    public void seleccionarGrupo (Grupo grupo) {
        this.setSelectedItem(grupo);
    }
}
