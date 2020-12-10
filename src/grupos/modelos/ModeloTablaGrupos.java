package grupos.modelos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaGrupos extends AbstractTableModel {
    private List<String> nombreColumnas = new ArrayList<>();
    private List<Grupo> grupos = new ArrayList<>();
    private GestorGrupos gg = GestorGrupos.crear();
    private List<Grupo> auxgrupos = new ArrayList<>();
    
    public ModeloTablaGrupos() {
        nombreColumnas.add("Nombre");
        nombreColumnas.add("Descripción");
        this.grupos = gg.verGrupos();
        this.actualizar();
    }

    @Override
    public int getColumnCount() {
        return this.nombreColumnas.size();
    }

    @Override
    public int getRowCount() {
        return this.grupos.size();
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Grupo g = this.grupos.get(fila);
        switch(columna) {
            case 0: return g.verNombre();
            default: return g.verDescripcion();
        }
    }

    @Override
    public String getColumnName(int columna) {
        return this.nombreColumnas.get(columna);
    }
    
    public Grupo verGrupo(int fila) {
        return this.grupos.get(fila);
    }
    
    public void BuscarGrupos(String nombre){
        this.auxgrupos.clear();
        this.grupos = gg.verGrupos();
        if (nombre.isBlank()){
           // this.alumnos.clear();
            this.grupos = gg.verGrupos();
            this.fireTableDataChanged();
        }
        else{
            for (Grupo g : this.grupos ){
                if(g.verNombre().contains(nombre)){
                    this.auxgrupos.add(g);
                }
            }
            this.grupos = this.auxgrupos;
            this.fireTableDataChanged();
        }
    }
    
    public void actualizar() {
        GestorGrupos gg = GestorGrupos.crear();
        this.grupos = gg.verGrupos();
        this.fireTableDataChanged();
    }
}