package grupos.controladores;

import autores.modelos.GestorAutores;
import grupos.modelos.GestorGrupos;
import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;
import grupos.modelos.ModeloTablaModificarMiembrosGrupo;
import grupos.vistas.VentanaModificarMiembros;
import interfaces.IControladorModificarMiembros;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.ListSelectionModel;

class ControladorModificarMiembros implements IControladorModificarMiembros{
    
    private VentanaModificarMiembros ventana;
    private GestorAutores ga = GestorAutores.crear();
    private GestorGrupos gg = GestorGrupos.crear();
    private Grupo grupoaux;
    
    public ControladorModificarMiembros(JDialog padre, boolean modal, Grupo grupo) {
        this.ventana = new VentanaModificarMiembros(padre, modal, this, grupo);
        this.grupoaux = grupo;
        this.ventana.setAutores(gg.verMiembros(grupo));
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
//        this.ventana.setBox(this.ventana.getTabla(), this.ventana.getTabla().getColumn(1));
//        this.actualizar();
    }
    
    @Override
    public void btnTodosClic(ActionEvent evt) {
        ModeloTablaModificarMiembrosGrupo mtmg = (ModeloTablaModificarMiembrosGrupo)this.ventana.getTabla().getModel();
        ListSelectionModel modeloSeleccion = this.ventana.getTabla().getSelectionModel();
        modeloSeleccion.addSelectionInterval(0, mtmg.getRowCount()-1);
    }

    @Override
    public void btnNingunoClic(ActionEvent evt) {
        ModeloTablaModificarMiembrosGrupo mtmg = (ModeloTablaModificarMiembrosGrupo)this.ventana.getTabla().getModel();
        ListSelectionModel modeloSeleccion = this.ventana.getTabla().getSelectionModel();
        modeloSeleccion.clearSelection();
    }

    @Override
    public void btnAceptarClic(ActionEvent evt) {
        //gg.agregarMiembros(this.grupoaux, miembros);
        ModeloTablaModificarMiembrosGrupo mtmg = (ModeloTablaModificarMiembrosGrupo)this.ventana.getTabla().getModel();
        List<MiembroEnGrupo> miembrosSeleccionados = new ArrayList<>();
        List<MiembroEnGrupo> miembrosSinSeleccion = new ArrayList<>();
        int[] filasSeleccionadas = this.ventana.getTabla().getSelectedRows();
        for (int fila : filasSeleccionadas){
            miembrosSeleccionados.add(mtmg.aceptar().get(fila));
        }
        gg.agregarMiembros(grupoaux, miembrosSeleccionados);
//        for(int i=0; i<mtmg.aceptar().size(); i++){
//            if(!(Arrays.asList(filasSeleccionadas).contains(i))){
//                 miembrosSinSeleccion.add(mtmg.aceptar().get(i));
//                 System.out.println("La fila "+i+"No esta seleccionado");
//            }   
//        }
        int b=0;
        for(int i = 0; i < mtmg.aceptar().size(); i++){
            for(int j = 0; j < filasSeleccionadas.length; j++){
                if (i == filasSeleccionadas[j]){
                    b=1;
                    break;
                }
            }
            if(b==0){
                miembrosSinSeleccion.add(mtmg.aceptar().get(i));
            }
            else{
                b=0;
            }
        }
        gg.quitarMiembros(grupoaux, miembrosSinSeleccion);
        this.ventana.setVisible(false);
        this.ventana.dispose();
        
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ventana.setVisible(false);
        this.ventana.dispose();
    }
//        public List <MiembroEnGrupo> seleccionados(){
//        List <MiembroEnGrupo> seleccionados = new ArrayList<>();
////        filas = Arrays.asList(this.jTable1.getSelectedRows());
//        int [] filasseleccionadas = this.ventana.getTabla().getSelectedRows();
//        for(int i=0; i< filasseleccionadas.length; i++){
//            Rol rol = this.ventana.getTabla().getValueAt(i, 1);
//            seleccionados.add(new MiembroEnGrupo(this.ventana.getTabla().getRow()));
//        }
//    }
//    public void ventanaObtenerFoco(){
//        ListSelectionModel modeloSeleccion = this.ventana.getTabla().getSelectionModel();
//        for(Autor autor : this.grupoaux.) {
//            for(int fila = 0; fila < mt.getRowCount(); fila++) {
//                PalabraClave pc = mt.verPalabraClave(fila);
//
//
//                if (palabraClave.equals(pc)) {
//                    modeloSeleccion.addSelectionInterval(fila, fila);
//                    break;
//                    }
//                }
//            }
//    }
}
