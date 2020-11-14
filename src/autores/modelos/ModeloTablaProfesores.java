/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Carlos
 */
public class ModeloTablaProfesores extends AbstractTableModel {
    private ArrayList<String> nombreColumnas = new ArrayList<>();
    private ArrayList<Profesor> autores = new ArrayList<>();
    
    public ModeloTablaProfesores() {
        nombreColumnas.add("DNI");
        nombreColumnas.add("Apellidos");
        nombreColumnas.add("Nombres");
        nombreColumnas.add("Cargo");
        GestorAutores ga = GestorAutores.crear();
        this.autores = ga.verProfesores();
        //Creo profesores
        ga.nuevoAutor(12312, "guzman", "Rodri", Cargo.ADG, "12345", "12345");
        ga.nuevoAutor(123412, "guzmanx", "Rodsi", Cargo.ADG, "1234s5", "1234s5");
        autores = ga.verProfesores();
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
        Profesor p = this.autores.get(fila);
        switch(columna) {
            case 0: return p.verDni();
            case 1: return p.verApellidos();
            case 2: return p.verNombres();
            default: return p.verCargo();
        }
    }

    @Override
    public String getColumnName(int columna) {
        return this.nombreColumnas.get(columna);
    }
    
//    public Espacio verEspacio(int fila) {
//        return this.espacios.get(fila);
//    }
//
//    @Override
//    public boolean isCellEditable(int fila, int columna) {
//        return true;
//    }
//
//    @Override
//    public void setValueAt(Object valor, int fila, int columna) {
//        Espacio e = this.espacios.get(fila);
//        switch(columna) {
//            case 0: e.setNombre((String)valor);
//                    break;
//            case 1: e.setCapacidad((Integer)valor);
//                    break;
//            default:e.setTipo((Tipo)valor);
//                    break;
//        }
//    }
//
//    @Override
//    public Class<?> getColumnClass(int columna) {
//        switch(columna) {
//            case 0: return String.class;
//            case 1: return Integer.class;
//            default: return String.class;
//        }
//    }
//    
//    
//    public void actualizar() {
//        GestorEspacios ge = GestorEspacios.crear();
//        this.espacios = ge.verEspacios();
//        this.fireTableDataChanged();
//    }
//    
    

}
