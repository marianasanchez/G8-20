package grupos.modelos;

import autores.modelos.*;
import grupos.modelos.MiembroEnGrupo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaModificarMiembrosGrupo extends AbstractTableModel {
    private List<String> nombreColumnas = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private GestorAutores ga = GestorAutores.crear();
    private GestorGrupos gg = GestorGrupos.crear();
    private Grupo grupo;
    private List<MiembroEnGrupo> megsAux = new ArrayList<>();
    
    public ModeloTablaModificarMiembrosGrupo(Grupo grupo) {
        nombreColumnas.add("Nombre");
        nombreColumnas.add("Rol");
        this.autores = ga.verAutores();
        for(Autor a : autores){
            megsAux.add(new MiembroEnGrupo(ga.verAutor(a.verDni()), grupo, a.verRol(a, grupo)));
        }
        this.grupo = grupo;
//        this.actualizar();
    }

    @Override
    public int getColumnCount() {
        return this.nombreColumnas.size();
    }

    @Override
    public int getRowCount() {
        return this.autores.size();
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Autor a = this.autores.get(fila);
        switch(columna) {
            case 0: return a.verNombres();
            default: 
                for(MiembroEnGrupo meg : megsAux){
                    if(a.equals(meg.verAutor())){
                        return meg.verRol();
                    }
                }
                return a.verRol(a, this.grupo);
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

    public void actualizar() {
//        this.autores = ga.verAutores();
        this.fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex == 1){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Autor a = this.autores.get(rowIndex);
        MiembroEnGrupo megAux = null;
        for(MiembroEnGrupo meg : megsAux){
            if(a.equals(meg.verAutor())){
                megAux = meg;
            }
        }
        switch(columnIndex){
            case 0:
                a.verNombres();
                break;
            default:
                megAux.asignarRol((Rol)aValue);
                for(MiembroEnGrupo meg : megsAux){
                    System.out.println(meg.verRol());
                }
                this.actualizar();
                break;
        }
        this.actualizar();
    } 

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case 0: return String.class;
            default: return Rol.class;
        }
    }
    
    public List <MiembroEnGrupo> aceptar(){
        //gg.quitarMiembros(grupo, megsAux);
        
//        gg.agregarMiembros(grupo, megsAux);
        return megsAux;
//      List<MiembroEnGrupo> agregar,List<MiembroEnGrupo> quitar
    }
    public Autor verAutor(int fila){
        return this.autores.get(fila);
    }
}