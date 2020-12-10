package autores.modelos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaAlumnos extends AbstractTableModel {
    private ArrayList<String> nombreColumnas = new ArrayList<>();
    private List<Alumno> alumnos = new ArrayList<>();
    private GestorAutores ga = GestorAutores.crear();
    private ArrayList<Alumno> auxAlumnos = new ArrayList<>();
    public ModeloTablaAlumnos() {
        nombreColumnas.add("DNI");
        nombreColumnas.add("Apellidos");
        nombreColumnas.add("Nombres");
        nombreColumnas.add("CX");
        this.alumnos = ga.verAlumnos();
        this.actualizar();
    }

    @Override
    public int getColumnCount() {
        return this.nombreColumnas.size();
    }

    @Override
    public int getRowCount() {
        return this.alumnos.size();
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Alumno a = this.alumnos.get(fila);
        switch(columna) {
            case 0: return a.verDni();
            case 1: return a.verApellidos();
            case 2: return a.verNombres();
            default: return a.verCx();
        }
    }

    @Override
    public String getColumnName(int columna) {
        return this.nombreColumnas.get(columna);
    }
    
    public Autor verAutor(int fila) {
        return this.alumnos.get(fila);
    }
    
    public void BuscarAlumnos(String apellido){
        this.auxAlumnos.clear();
        this.alumnos = ga.verAlumnos();
        if (apellido.isBlank()){
            this.alumnos = ga.verAlumnos();
            this.fireTableDataChanged();
        }
        else{
            for (Autor a : this.alumnos ){
                if(a.verApellidos().toLowerCase().contains(apellido.toLowerCase())){
                    this.auxAlumnos.add((Alumno)a);
                }
            }
            this.alumnos = this.auxAlumnos;
            this.fireTableDataChanged();
        }
    }
    
    public void actualizar() {
        GestorAutores ga = GestorAutores.crear();
        this.alumnos = ga.verAlumnos();
        this.fireTableDataChanged();
    }
}