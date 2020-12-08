package grupos.modelos;

import autores.modelos.*;
import grupos.modelos.MiembroEnGrupo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaMiembrosGrupo extends AbstractTableModel {
    private List<String> nombreColumnas = new ArrayList<>();
    private List<Autor> autoresMiembros = new ArrayList<>();
    private GestorAutores ga = GestorAutores.crear();
    private GestorGrupos gg = GestorGrupos.crear();
    
    public ModeloTablaMiembrosGrupo(Grupo grupo) {
        nombreColumnas.add("Nombre");
        nombreColumnas.add("Rol");
        if(grupo != null){
            this.autoresMiembros = gg.verMiembros(grupo);
        }
//        this.actualizar();
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
            case 0: return a.verNombres();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int columna) {
        return this.nombreColumnas.get(columna);
    }
    
    
    
//    public Autor verAutor(int fila) {
//        return this.profesores.get(fila);
//    }
//    
//    public void BuscarProfesores(String apellido){
//        this.auxProfesores.clear();
//        this.profesores = ga.verProfesores();
//        if (apellido.isBlank()){
//           // this.profesores.clear();
//            this.profesores = ga.verProfesores();
//            this.fireTableDataChanged();
//        }
//        else{
//            for (Autor a : this.profesores ){
//                if(a.verApellidos().contains(apellido)){
//                    this.auxProfesores.add((Profesor)a);
//                }
//            }
//            this.profesores = this.auxProfesores;
//            this.fireTableDataChanged();
//        }
//    }
//    
//    public void actualizar() {
//        GestorAutores ga = GestorAutores.crear();
//        this.profesores = ga.verProfesores();
//        this.fireTableDataChanged();
//    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex == 1){
            return true;
        }
        else{
            return false;
        }
    }
}
