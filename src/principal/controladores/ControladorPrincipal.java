//<editor-fold defaultstate="collapsed" desc="Parcial N° 2">
package principal.controladores;

import autores.controladores.ControladorAutores;
import autores.modelos.Cargo;
import autores.modelos.GestorAutores;
import grupos.controladores.ControladorGrupos;
import grupos.modelos.GestorGrupos;
import idiomas.modelos.GestorIdiomas;
import interfaces.IControladorPrincipal;
import java.awt.event.ActionEvent;
import lugares.modelos.GestorLugares;
import palabrasclaves.modelos.GestorPalabrasClaves;
import principal.vistas.VentanaPrincipal;
import publicaciones.controladores.ControladorPublicaciones;
import tipos.modelos.GestorTipos;

public class ControladorPrincipal implements IControladorPrincipal{
    
    private VentanaPrincipal ventana;
    private GestorPalabrasClaves gpc = GestorPalabrasClaves.crear();
    private GestorLugares gl = GestorLugares.crear();
    private GestorIdiomas gi = GestorIdiomas.crear();
    private GestorTipos gt = GestorTipos.crear();
    
    
    private GestorAutores ga = GestorAutores.crear();
    private GestorGrupos gg = GestorGrupos.crear();
    
    public ControladorPrincipal() {
        this.ventana = new VentanaPrincipal(this);
        
        System.out.println(ga.nuevoAutor(1, "Apellido1", "Nombre1", Cargo.ADG, "a", "a"));
        System.out.println(ga.nuevoAutor(2, "Apellido2", "Nombre2", Cargo.TITULAR, "a", "a"));
        System.out.println(ga.nuevoAutor(3, "Apellido3", "Nombre3", Cargo.ADJUNTO, "a", "a"));
        System.out.println(ga.nuevoAutor(4, "Apellido4", "Nombre4", Cargo.JTP, "a", "a"));
        System.out.println(ga.nuevoAutor(5, "Apellido5", "Nombre5", Cargo.ADG, "a", "a"));
        
        System.out.println(gg.nuevoGrupo("Grupo 1", "Descripcion 1"));
        
        
        
        System.out.println(gpc.nuevaPalabraClave("Hardware"));
        System.out.println(gpc.nuevaPalabraClave("Software"));
        System.out.println(gpc.nuevaPalabraClave("Microcontroladores"));
        System.out.println(gpc.nuevaPalabraClave("Programación"));
        System.out.println(gpc.nuevaPalabraClave("Java"));
        
        System.out.println(gl.nuevoLugar("Aula"));
        System.out.println(gl.nuevoLugar("Laboratorio"));
        System.out.println(gl.nuevoLugar("Anfiteatro"));
        System.out.println(gl.nuevoLugar("Block"));
        System.out.println(gl.nuevoLugar("Oficina"));
        
        System.out.println(gi.nuevoIdioma("Español"));
        System.out.println(gi.nuevoIdioma("Inglés"));
        System.out.println(gi.nuevoIdioma("Alemán"));
        System.out.println(gi.nuevoIdioma("Francés"));
        System.out.println(gi.nuevoIdioma("Portugues"));
        System.out.println(gi.verIdiomas());
        
        System.out.println(gt.nuevoTipo("Tesis"));
        System.out.println(gt.nuevoTipo("Informe"));
        System.out.println(gt.nuevoTipo("Artículo"));
        System.out.println(gt.nuevoTipo("Libro"));
        System.out.println(gt.nuevoTipo("Ensayo"));
        
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }
    
    @Override
    public void btnGruposClic(ActionEvent evt) {
        ControladorGrupos grupos = new ControladorGrupos(this.ventana, true);
    }
    
    @Override
    public void btnAutoresClic(ActionEvent evt) {
        ControladorAutores autores = new ControladorAutores(this.ventana, true);
    }
    
    @Override
    public void btnPublicacionesClic(ActionEvent evt) {
        ControladorPublicaciones publicaciones = new ControladorPublicaciones(this.ventana, true);
    }

    @Override
    public void btnSalirClic(ActionEvent evt) {
        ControladorSalir salir = new ControladorSalir(this.ventana, true);
    }
    
    

    @Override
    public void btnPalabrasClavesClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnLugaresClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnIdiomasClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnTiposClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
}
//</editor-fold>