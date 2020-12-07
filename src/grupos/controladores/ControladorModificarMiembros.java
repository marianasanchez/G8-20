package grupos.controladores;

import autores.modelos.GestorAutores;
import grupos.modelos.GestorGrupos;
import grupos.modelos.Grupo;
import grupos.modelos.ModeloTablaModificarGrupo;
import grupos.vistas.VentanaModificarMiembros;
import interfaces.IControladorModificarMiembros;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import javax.swing.ListSelectionModel;

class ControladorModificarMiembros implements IControladorModificarMiembros{
    
    private VentanaModificarMiembros ventana;
    private GestorAutores ga = GestorAutores.crear();
    private GestorGrupos gg = GestorGrupos.crear();
    private Grupo grupoaux;
    
    public ControladorModificarMiembros(JDialog padre, boolean modal, Grupo grupo) {
        this.ventana = new VentanaModificarMiembros(padre, modal, this);
        this.grupoaux = grupo;
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
        this.ventana.setBox(this.ventana.getTabla(), this.ventana.getTabla().getColumn(1));
//        this.actualizar();
    }
    
    @Override
    public void btnTodosClic(ActionEvent evt) {
        ModeloTablaModificarGrupo mtmg = (ModeloTablaModificarGrupo)this.ventana.getTabla().getModel();
        ListSelectionModel modeloSeleccion = this.ventana.getTabla().getSelectionModel();
        modeloSeleccion.addSelectionInterval(0, mtmg.getRowCount()-1);
    }

    @Override
    public void btnNingunoClic(ActionEvent evt) {
        ModeloTablaModificarGrupo mtmg = (ModeloTablaModificarGrupo)this.ventana.getTabla().getModel();
        ListSelectionModel modeloSeleccion = this.ventana.getTabla().getSelectionModel();
        modeloSeleccion.clearSelection();
    }

    @Override
    public void btnAceptarClic(ActionEvent evt) {
        gg.agregarMiembros(this.grupoaux, miembros);
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ventana.setVisible(false);
        this.ventana.dispose();
    }
    
}
