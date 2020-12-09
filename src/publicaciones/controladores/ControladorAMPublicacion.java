/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.controladores;

import autores.modelos.GestorAutores;
import grupos.modelos.GestorGrupos;
import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;
import grupos.modelos.ModeloComboGrupos;
import idiomas.modelos.GestorIdiomas;
import idiomas.modelos.Idioma;
import idiomas.modelos.ModeloComboIdiomas;
import interfaces.IControladorAMPublicacion;
import interfaces.IControladorPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import lugares.modelos.GestorLugares;
import lugares.modelos.Lugar;
import lugares.modelos.ModeloComboLugares;
import palabrasclaves.modelos.GestorPalabrasClaves;
import palabrasclaves.modelos.PalabraClave;
import publicaciones.modelos.GestorPublicaciones;
import publicaciones.modelos.ModeloTablaPalabrasClaves;
import publicaciones.modelos.Publicacion;
import publicaciones.vistas.VentanaAMPublicacion;
import tipos.modelos.GestorTipos;
import tipos.modelos.ModeloComboTipos;
import tipos.modelos.Tipo;

/**
 *
 * @author Carlos
 */
class ControladorAMPublicacion implements IControladorAMPublicacion {
    private VentanaAMPublicacion ventana;
    private GestorPublicaciones gp = GestorPublicaciones.crear();
    private GestorGrupos gg = GestorGrupos.crear();
    private GestorTipos gt = GestorTipos.crear();
    private GestorLugares gl = GestorLugares.crear();
    private GestorIdiomas gi = GestorIdiomas.crear();
    private GestorAutores ga = GestorAutores.crear();
    private GestorPalabrasClaves gpc = GestorPalabrasClaves.crear();
    private boolean crear;
    private Grupo grupoaux;
    private Lugar lugaraux;
    private Tipo tipoaux;
    private Idioma idiomaaux;
    private Publicacion publicacionAux;
    
    public ControladorAMPublicacion(String title, boolean crear, JDialog padre, boolean modal) {
        this.crear=crear;
        this.ventana = new VentanaAMPublicacion(padre, modal, this, crear);
        this.ventana.setTitle(title);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }
    
    public ControladorAMPublicacion(String title, boolean crear, JDialog padre, boolean modal, Publicacion publicacion){
        this.crear=crear;
        this.publicacionAux = publicacion;
        this.ventana = new VentanaAMPublicacion(padre, modal, this, crear);
        this.ventana.setTitle(title);
        this.ventana.setTitulo(publicacion.verTitulo());
        this.ventana.enableTitulo(crear);
        this.ventana.setFecha(publicacion.verFechaPublicacion());
        this.ventana.setEnlace(publicacion.verEnlace());
        this.ventana.setGrupo(publicacion.verMiembroEnGrupo().verGrupo().verNombre());
        this.ventana.setLugar(publicacion.verLugar().verNombre());
        this.ventana.setTipo(publicacion.verTipo().verNombre());
        this.ventana.setIdioma(publicacion.verIdioma().verNombre());
        this.ventana.setPalabrasClaves(publicacion.verPalabrasClaves());
        this.ventana.setResumen(publicacion.verResumen());
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        if(crear == true){
            MiembroEnGrupo meg = new MiembroEnGrupo(ga.verAutores().get(0), gg.verGrupo(this.ventana.getGrupo()),ga.verAutores().get(0).verRol(ga.verAutores().get(0),gg.verGrupo(this.ventana.getGrupo())));

            List<PalabraClave> palabrasClaves = new ArrayList<>();
            int[] filasSeleccionadas = this.ventana.getTabla().getSelectedRows();
            for (int fila : filasSeleccionadas){
                palabrasClaves.add(gpc.verPalabrasClaves().get(fila));
            }

            System.out.println(gp.nuevaPublicacion(this.ventana.getTitulo(), meg, this.ventana.getFecha(), gt.verTipo(this.ventana.getTipo()), gi.verIdioma(this.ventana.getIdioma()), gl.verLugar(this.ventana.getLugar()), palabrasClaves, this.ventana.getEnlace(), this.ventana.getResumen()));
        }
        
        else {
           MiembroEnGrupo meg = new MiembroEnGrupo(ga.verAutores().get(0),gg.verGrupo(this.ventana.getGrupo()),ga.verAutores().get(0).verRol(ga.verAutores().get(0),gg.verGrupo(this.ventana.getGrupo())));

            List<PalabraClave> palabrasClaves = new ArrayList<>();
            int[] filasSeleccionadas = this.ventana.getTabla().getSelectedRows();
            for (int fila : filasSeleccionadas){
                palabrasClaves.add(gpc.verPalabrasClaves().get(fila));
            }

            System.out.println(gp.modificarPublicacion(this.publicacionAux, meg, this.ventana.getFecha(), gt.verTipo(this.ventana.getTipo()), gi.verIdioma(this.ventana.getIdioma()), gl.verLugar(this.ventana.getLugar()), palabrasClaves, this.ventana.getEnlace(), this.ventana.getResumen())); 
        }
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ventana.setVisible(false);
        this.ventana.dispose(); 
    }

    @Override
    public void txtTituloPresionarTecla(KeyEvent evt) {
                char c = evt.getKeyChar();
        if (!Character.isLetter(c) && !Character.isDigit(c)) {
            switch(c) {
                case KeyEvent.VK_ENTER:    
                   this.btnGuardarClic(null);
                case KeyEvent.VK_BACK_SPACE:
                case KeyEvent.VK_SPACE:
                case KeyEvent.VK_DELETE:
                    break;
                default:                    
                    evt.consume();
                    break;
            }
        }
    }

    @Override
    public void btnTodasLasPalabrasClavesClic(ActionEvent evt) {
        ModeloTablaPalabrasClaves mtpc = (ModeloTablaPalabrasClaves)this.ventana.getTabla().getModel();
        ListSelectionModel modeloSeleccion = this.ventana.getTabla().getSelectionModel();
        modeloSeleccion.addSelectionInterval(0, mtpc.getRowCount()-1);
    }

    @Override
    public void btnNingunaPalabraClaveClic(ActionEvent evt) {
        ModeloTablaPalabrasClaves mtpc = (ModeloTablaPalabrasClaves)this.ventana.getTabla().getModel();
        ListSelectionModel modeloSeleccion = this.ventana.getTabla().getSelectionModel();
        modeloSeleccion.clearSelection();
    }

    @Override
    public void btnAbrirClic(ActionEvent evt) {

        //Se ponen en español los nombres de los botones de la ventana de diálogo
        UIManager.put("FileChooser.openButtonText","Abrir");
        UIManager.put("FileChooser.openButtonToolTipText", "Abrir");
        UIManager.put("FileChooser.cancelButtonText","Cancelar");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Cancelar");
        UIManager.put("FileChooser.lookInLabelText", "Buscar en:");
        UIManager.put("FileChooser.fileNameLabelText", "Archivo:");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Archivos del tipo:");
        UIManager.put("FileChooser.upFolderToolTipText", "Subir un nivel");
        UIManager.put("FileChooser.homeFolderToolTipText", "Inicio");
        UIManager.put("FileChooser.newFolderToolTipText", "Carpeta nueva");
        UIManager.put("FileChooser.listViewButtonToolTipText", "Lista");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Detalles");
        
        JFileChooser selector = new JFileChooser();
        selector.setCurrentDirectory(new File(System.getProperty("user.home")));
        //se establece la carpeta personal del usuario para empezar la búsqueda
        selector.setDialogTitle(IControladorPrincipal.TITULO);
        selector.setAcceptAllFileFilterUsed(false); //no se muestra el filtro de todos los archivos
        
        int resultado = selector.showOpenDialog(null);
        
        if (resultado == JFileChooser.APPROVE_OPTION) { //se selecciona un archivo
            File selectedFile = selector.getSelectedFile();
            this.ventana.verTxtEnlace(selectedFile.getAbsolutePath());
        }        
    }
    

}
