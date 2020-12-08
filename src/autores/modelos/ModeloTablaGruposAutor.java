package autores.modelos;

import grupos.modelos.GestorGrupos;
import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaGruposAutor extends AbstractTableModel {
    private List<String> nombreColumnas = new ArrayList<>();
    private List<Grupo> grupos = new ArrayList<>();
    private GestorAutores ga = GestorAutores.crear();
    private GestorGrupos gg = GestorGrupos.crear();
    private Autor autor;
    
    public ModeloTablaGruposAutor(Autor autor) {
        nombreColumnas.add("Nombre");
        nombreColumnas.add("Rol");
        if(autor != null){
            this.autor = autor;
            this.grupos = autor.mostrarGrupos();
        }
//        this.actualizar();
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
        Grupo g = this.autor.mostrarGrupos().get(fila);
        MiembroEnGrupo mgaux=null;
        for (MiembroEnGrupo mg: autor.mostrarMiembroEnGrupos()){
            if(g.equals(mg.verGrupo())){
                mgaux=mg;
            }
        }
        switch(columna) {
            case 0: return g.verNombre();
            default: return mgaux.verRol();
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
