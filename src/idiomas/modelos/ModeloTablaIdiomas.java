package idiomas.modelos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaIdiomas extends AbstractTableModel {
    private List<String> nombreColumnas = new ArrayList<>();
    private List<Idioma> idiomas = new ArrayList<>();
    private GestorIdiomas gi = GestorIdiomas.crear();
    private List<Idioma> auxIdiomas = new ArrayList<>();
    public ModeloTablaIdiomas() {
        nombreColumnas.add("Idiomas");
        this.idiomas = gi.verIdiomas();
        this.actualizar();
    }

    @Override
    public int getColumnCount() {
        return this.nombreColumnas.size();
    }

    @Override
    public int getRowCount() {
        return this.idiomas.size();
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Idioma i = this.idiomas.get(fila);
        return i.verNombre();

    }

    @Override
    public String getColumnName(int columna) {
        return this.nombreColumnas.get(columna);
    }
    
    public Idioma verIdioma(int fila) {
        return this.idiomas.get(fila);
    }
    
    public void BuscarIdiomas(String nombre){
        this.auxIdiomas.clear();
        this.idiomas = gi.verIdiomas();
        if (nombre.isBlank()){
           // this.alumnos.clear();
            this.idiomas = gi.verIdiomas();
            this.fireTableDataChanged();
        }
        else{
            for (Idioma i : this.idiomas ){
                if(i.verNombre().toLowerCase().contains(nombre.toLowerCase())){
                    this.auxIdiomas.add(i);
                }
            }
            this.idiomas = this.auxIdiomas;
            this.fireTableDataChanged();
        }
    }
    
    public void actualizar() {
        GestorIdiomas gi = GestorIdiomas.crear();
        this.idiomas = gi.verIdiomas();
        this.fireTableDataChanged();
    }
}
