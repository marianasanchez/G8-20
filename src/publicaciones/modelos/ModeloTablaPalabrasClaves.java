package publicaciones.modelos;

import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import palabrasclaves.modelos.GestorPalabrasClaves;
import palabrasclaves.modelos.PalabraClave;

public class ModeloTablaPalabrasClaves extends AbstractTableModel{
    private List<String> nombreColumnas = new ArrayList<>();
    private List<PalabraClave> palabrasclaves = new ArrayList<>();
    private GestorPalabrasClaves gpc = GestorPalabrasClaves.crear();
    private List<Publicacion> auxpalabrasclaves = new ArrayList<>();
    
    public ModeloTablaPalabrasClaves() {
        nombreColumnas.add("Nombre");

        this.palabrasclaves = gpc.verPalabrasClaves();
        this.actualizar();
    }

    @Override
    public int getColumnCount() {
        return this.nombreColumnas.size();
    }

    @Override
    public int getRowCount() {
        return this.palabrasclaves.size();
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        PalabraClave p = this.palabrasclaves.get(fila);
        return p.verNombre();
    }

    @Override
    public String getColumnName(int columna) {
        return this.nombreColumnas.get(columna);
    }
    
    public PalabraClave verPalabraClave(int fila) {
        return this.palabrasclaves.get(fila);
    }
    
    public void actualizar() {
        GestorPalabrasClaves gpc = GestorPalabrasClaves.crear();
        this.palabrasclaves = gpc.verPalabrasClaves();
        this.fireTableDataChanged();
    }
}
