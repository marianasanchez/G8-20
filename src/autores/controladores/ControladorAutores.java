package autores.controladores;

import autores.modelos.GestorAutores;
import autores.modelos.ModeloTablaAlumnos;
import autores.modelos.ModeloTablaProfesores;
import autores.vistas.VentanaAMAutores;
import interfaces.IControladorAutores;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public class ControladorAutores implements IControladorAutores {
    private VentanaAMAutores ventana;
    private GestorAutores ga = GestorAutores.crear();
    
    public ControladorAutores() {
        this.ventana = new VentanaAMAutores(this);
        this.ventana.autoresCargados();
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
        this.actualizar();
    }
    
    @Override
    public void btnNuevoProfesorClic(ActionEvent evt) {
        ControladorAMProfesor controlador = new ControladorAMProfesor("Nuevo Profesor", true, true);
        this.ventana.setVisible(false);
        this.ventana.dispose();
    }

    @Override
    public void btnNuevoAlumnoClic(ActionEvent evt) {
        ControladorAMAlumno controlador = new ControladorAMAlumno("Nuevo Alumno", true, true);
        this.ventana.setVisible(false);
        this.ventana.dispose();
    }

    @Override
    public void btnModificarProfesorClic(ActionEvent evt) {
        ControladorAMProfesor controlador = new ControladorAMProfesor("Modificar Profesor", false, false, this.ventana.verProfesor());
        System.out.println(this.ventana.verProfesor());
        this.ventana.setVisible(false);
        this.ventana.dispose();
    }

    @Override
    public void btnModificarAlumnoClic(ActionEvent evt) {
        ControladorAMAlumno controlador = new ControladorAMAlumno("Modificar Alumno", false, false, this.ventana.verAlumno());
        System.out.println(this.ventana.verAlumno());
        this.ventana.setVisible(false);
        this.ventana.dispose();
    }

    @Override
    public void btnBorrarProfesorClic(ActionEvent evt) {
        ga.BorrarAutor(this.ventana.verDniProfesor());
        ModeloTablaProfesores mtp = (ModeloTablaProfesores)this.ventana.getTablaProfesores().getModel();
        mtp.actualizar();
    }

    @Override
    public void btnBorrarAlumnoClic(ActionEvent evt) {
        ga.BorrarAutor(this.ventana.verDniAlumno());
        ModeloTablaAlumnos mtp = (ModeloTablaAlumnos)this.ventana.getTablaAlumnos().getModel();
        mtp.actualizar();
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.ventana.setVisible(false);
        this.ventana.dispose();
    }

    @Override
    public void btnBuscarProfesorClic(ActionEvent evt) {
        ModeloTablaProfesores mtp = (ModeloTablaProfesores)this.ventana.getTablaProfesores().getModel();
        mtp.BuscarProfesores(this.ventana.getBusquedaProfesores());  
    }

    @Override
    public void btnBuscarAlumnoClic(ActionEvent evt) {
        ModeloTablaAlumnos mta = (ModeloTablaAlumnos)this.ventana.getTablaAlumnos().getModel();
        mta.BuscarAlumnos(this.ventana.getBusquedaAlumnos());
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void txtApellidosProfesorPresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isLetter(c)) {
            switch(c) {
                case KeyEvent.VK_ENTER:                
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
    public void txtApellidosAlumnoPresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isLetter(c)) {
            switch(c) {
                case KeyEvent.VK_ENTER:                
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
    
    public void actualizar(){
        ModeloTablaProfesores mtp = (ModeloTablaProfesores)this.ventana.getTablaProfesores().getModel();
        mtp.actualizar();
    }
}
