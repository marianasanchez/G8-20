package grupos.modelos;

import autores.modelos.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaMiembrosGrupo extends AbstractTableModel {
    private List<String> nombreColumnas = new ArrayList<>();
    private List<Autor> autoresMiembros = new ArrayList<>();
    private GestorAutores ga = GestorAutores.crear();
    private GestorGrupos gg = GestorGrupos.crear();
    private Grupo grupo;
    
    public ModeloTablaMiembrosGrupo(Grupo grupo) {
        nombreColumnas.add("Nombre");
        nombreColumnas.add("Rol");
        this.grupo = grupo;
        if(grupo != null){
            this.autoresMiembros = gg.verMiembros(grupo);
        }
        this.actualizar();
    }

    @Override
    public int getColumnCount() {
        return this.nombreColumnas.size();
    }

    @Override
    public int getRowCount() {
        return this.autoresMiembros.size();
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Autor a = this.autoresMiembros.get(fila);
        switch(columna) {
            case 0: 
                String autor = a.verApellidos() + ", " + a.verNombres();
                return autor;
            default: return a.verRol(a, grupo);
        }
    }

    @Override
    public String getColumnName(int columna) {
        return this.nombreColumnas.get(columna);
    }
    
    public void actualizar() {
        if(grupo != null){
            this.autoresMiembros = gg.verMiembros(grupo);
        }
        this.fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
