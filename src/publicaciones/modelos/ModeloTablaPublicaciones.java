/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.modelos;

import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Carlos
 */
public class ModeloTablaPublicaciones extends AbstractTableModel{
    private List<String> nombreColumnas = new ArrayList<>();
    private List<Publicacion> publicaciones = new ArrayList<>();
    private GestorPublicaciones gp = GestorPublicaciones.crear();
    private List<Publicacion> auxpublicaciones = new ArrayList<>();
    
    public ModeloTablaPublicaciones() {
        nombreColumnas.add("Título");
        nombreColumnas.add("Autor");
        nombreColumnas.add("Año");
        this.publicaciones = gp.verPublicaciones();
        this.actualizar();
    }

    @Override
    public int getColumnCount() {
        return this.nombreColumnas.size();
    }

    @Override
    public int getRowCount() {
        return this.publicaciones.size();
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Publicacion p = this.publicaciones.get(fila);
        switch(columna) {
            case 0: return p.verTitulo();
            case 1: return p.verMiembroEnGrupo().verAutor().verApellidos();//mostrar apellido y nombre
            default: return p.verFechaPublicacion();//mostrar año
        }
    }

    @Override
    public String getColumnName(int columna) {
        return this.nombreColumnas.get(columna);
    }
    
    public Publicacion verPublicacion(int fila) {
        return this.publicaciones.get(fila);
    }
    
    public void BuscarPublicaciones(String titulo){
        this.auxpublicaciones.clear();
        this.publicaciones = gp.verPublicaciones();
        if (titulo.isBlank()){
           // this.alumnos.clear();
            this.publicaciones = gp.verPublicaciones();
            this.fireTableDataChanged();
        }
        else{
            for (Publicacion p : this.publicaciones ){
                if(p.verTitulo().contains(titulo)){
                    this.auxpublicaciones.add(p);
                }
            }
            this.publicaciones = this.auxpublicaciones;
            this.fireTableDataChanged();
        }
    }
    
    public void actualizar() {
        GestorPublicaciones gp = GestorPublicaciones.crear();
        this.publicaciones = gp.verPublicaciones();
        this.fireTableDataChanged();
    }
}
