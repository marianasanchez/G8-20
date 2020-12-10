package grupos.controladores;

import grupos.modelos.GestorGrupos;
import grupos.modelos.Grupo;
import grupos.modelos.ModeloTablaMiembrosGrupo;
import grupos.vistas.VentanaAMGrupo;
import interfaces.IControladorAMGrupo;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import publicaciones.controladores.ControladorMensaje;

class ControladorAMGrupo implements IControladorAMGrupo{
    private VentanaAMGrupo ventana;
    private GestorGrupos gg = GestorGrupos.crear();
    private boolean crear;
    
    public ControladorAMGrupo(String title, boolean modificarEnabled, JDialog padre, boolean modal) {
        this.crear = !modificarEnabled;
        this.ventana = new VentanaAMGrupo(padre, modal, this, null);
        this.ventana.setTitle(title);
        this.ventana.modificarEnabled(modificarEnabled, null);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }
    
    public ControladorAMGrupo(String title, boolean modificarEnabled, Grupo grupo, JDialog padre, boolean modal){
        this.crear = !modificarEnabled;
        this.ventana = new VentanaAMGrupo(padre, modal, this, grupo);
        this.ventana.setTitle(title);
        this.ventana.modificarEnabled(modificarEnabled, grupo);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        String mensaje;
        if(crear == true){
            mensaje = this.gg.nuevoGrupo(this.ventana.getNombre(), this.ventana.getDescripcion());
            if(mensaje.equals(gg.EXITO)){
                this.ventana.setVisible(false);
                this.ventana.dispose();
            }
        }
        else {
            mensaje = this.gg.modificarGrupo(gg.verGrupo(this.ventana.getNombre()), this.ventana.getDescripcion());
            if(mensaje.equals(gg.MODIFICADO)){
                this.ventana.setVisible(false);
                this.ventana.dispose();
            }
        }
        ControladorMensaje cont = new ControladorMensaje(this.ventana, true, mensaje);
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ventana.setVisible(false);
        this.ventana.dispose(); 
    }

    @Override
    public void btnModificarMiembrosClic(ActionEvent evt) {
        ControladorModificarMiembros controlador = new ControladorModificarMiembros(this.ventana, true, gg.verGrupo(this.ventana.getNombre()));
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
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
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
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
    public void ventanaObtenerFoco(WindowEvent evt) {
        ModeloTablaMiembrosGrupo mtmg = (ModeloTablaMiembrosGrupo)this.ventana.getTabla().getModel();
        mtmg.actualizar();
    }
}
