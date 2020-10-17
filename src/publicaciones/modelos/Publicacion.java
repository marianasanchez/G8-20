/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.modelos;

import grupos.modelos.MiembroEnGrupo;
import idiomas.modelos.Idioma;
import java.time.LocalDate;
import java.util.ArrayList;
import lugares.modelos.Lugar;
import palabrasclaves.modelos.PalabraClave;
import tipos.modelos.Tipo;

/**
 *
 * @author rodrigo
 */
public class Publicacion {
    private String titulo;
    private LocalDate fechaPublicacion;
    private String enlace;
    private String resumen;
    private Tipo tipo;
    private Idioma idioma;
    private Lugar lugar;
    private MiembroEnGrupo miembroEnGrupo;
    private ArrayList<PalabraClave> palabrasClaves;

    public Publicacion(String titulo, MiembroEnGrupo miembroEnGrupo, LocalDate fechaPublicacion, Tipo tipo, Idioma idioma, Lugar lugar, ArrayList<PalabraClave> palabrasClaves, String enlace, String resumen) {
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.enlace = enlace;
        this.resumen = resumen;
        this.tipo = tipo;
        this.idioma = idioma;
        this.lugar = lugar;
        this.miembroEnGrupo = miembroEnGrupo;
        this.palabrasClaves = palabrasClaves;
    }

    public String verTitulo() {
        return titulo;
    }

    public void asignarTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate verFechaPublicacion() {
        return fechaPublicacion;
    }

    public void asignarFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String verEnlace() {
        return enlace;
    }

    public void asignarEnlace(String enlace) {
        this.enlace = enlace;
    }

    public String verResumen() {
        return resumen;
    }

    public void asignarResumen(String resumen) {
        this.resumen = resumen;
    }
    
    public Tipo verTipo() {
        return tipo;
    }

    public void asignarTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Idioma verIdioma() {
        return idioma;
    }

    public void asignarIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Lugar verLugar() {
        return lugar;
    }

    public void asignarLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public ArrayList<PalabraClave> verPalabrasClaves() {
        return palabrasClaves;
    }

    public void asignarPalabrasClaves(ArrayList<PalabraClave> palabrasClaves) {
        this.palabrasClaves = palabrasClaves;
    }
    
    public MiembroEnGrupo verMiembroEnGrupo() {
        return miembroEnGrupo;
    }

    public void asignarMiembroEnGrupo(MiembroEnGrupo miembroEnGrupo) {
        this.miembroEnGrupo = miembroEnGrupo;
    }
    
    public void mostrar() {
        System.out.println("Título: " + this.titulo);
        System.out.println("Autor: ");
        System.out.println("Grupo: " + miembroEnGrupo.verGrupo().verNombre());
        System.out.println("Rol: " + miembroEnGrupo.verRol().name());
        System.out.println("Fecha de publicación: " + this.fechaPublicacion);
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Idioma: " + this.idioma);
        System.out.println("Lugar: " + this.lugar);
        System.out.println("Palabras claves\n---------------");
        for(PalabraClave pc : palabrasClaves) {
           System.out.println("\t" + pc); 
        }
        System.out.println("Enlace: " + this.enlace);
        System.out.println("Resumen" + this.resumen);
    }
    
}
