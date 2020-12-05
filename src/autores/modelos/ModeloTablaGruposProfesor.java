package autores.modelos;

import grupos.modelos.MiembroEnGrupo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaGruposProfesor extends AbstractTableModel {
    private List<String> nombreColumnas = new ArrayList<>();
    private List<MiembroEnGrupo> miembrosEnGrupos = new ArrayList<>();
//    private GestorAutores ga = GestorAutores.crear();
//    private List<Profesor> auxProfesores = new ArrayList<>();
    
    public ModeloTablaGruposProfesor() {
        nombreColumnas.add("Nombre");
        nombreColumnas.add("Rol");
//        this.miembrosEnGrupos = ga.verProfesores();
//        this.actualizar();
    }

    @Override
    public int getColumnCount() {
        return this.nombreColumnas.size();
    }

    @Override
    public int getRowCount() {
        return this.miembrosEnGrupos.size();
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        MiembroEnGrupo meg = this.miembrosEnGrupos.get(fila);
        switch(columna) {
            case 0: return meg.verGrupo().verNombre();
            default: return meg.verRol();
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
}
