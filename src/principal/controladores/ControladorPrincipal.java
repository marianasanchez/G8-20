/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.controladores;

import autores.modelos.Alumno;
import autores.modelos.Cargo;
import autores.modelos.Profesor;
import autores.vistas.VentanaAMAlumno;
import autores.vistas.VentanaAMProfesor;
import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;
import grupos.modelos.Rol;
import grupos.vistas.VentanaAMGrupo;
import idiomas.modelos.Idioma;
import idiomas.vistas.VentanaAIdioma;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JDialog;
import lugares.modelos.Lugar;
import lugares.vistas.VentanaALugar;
import palabrasclaves.modelos.PalabraClave;
import palabrasclaves.vistas.VentanaAPalabraClave;
import publicaciones.modelos.Publicacion;
import tipos.modelos.Tipo;
import tipos.vistas.VentanaATipo;

public class ControladorPrincipal {
    public static void main(String args[]) {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        ArrayList<Profesor> profesores = new ArrayList<>();
        ArrayList<Idioma> idiomas = new ArrayList<>();
        ArrayList<Lugar> lugares = new ArrayList<>();
        ArrayList<PalabraClave> palabrasClaves = new ArrayList<>();
        ArrayList<Tipo> tipos = new ArrayList<>();
        ArrayList<Grupo> grupos = new ArrayList<>();
        ArrayList<Publicacion> publicaciones = new ArrayList<>();
        
        //Instanciar Alumnos y agregarlos al ArrayList
        Alumno alumno1 = new Alumno(1, "A", "a", "1-1", "C1");
        alumnos.add(alumno1);
        
        Alumno alumno2 = new Alumno(2, "B", "b", "1-2", "C2");
        alumnos.add(alumno2);
        
        Alumno alumno3 = new Alumno(3, "C", "c", "1-3", "C3");
        alumnos.add(alumno3);
        
        Alumno alumno4 = new Alumno(4, "D", "d", "1-4", "C4");
        alumnos.add(alumno4);
        
        Alumno alumno5 = new Alumno(5, "D", "d", "1-5", "C5");
        alumnos.add(alumno5);
        
//        for(Alumno a: alumnos){
//            a.mostrar();
//        }
        
        //Instanciar Profesor y agregarlos al ArrayList
        Profesor profesor1 = new Profesor(6, "F", "f", "C6", Cargo.TITULAR);
        profesores.add(profesor1);
       
        Profesor profesor2 = new Profesor(7, "G", "g", "C7", Cargo.ADJUNTO);
        profesores.add(profesor2);
        
        Profesor profesor3 = new Profesor(8, "H", "h", "C8", Cargo.ADG);
        profesores.add(profesor3);
        
        Profesor profesor4 = new Profesor(9, "I", "i", "C9", Cargo.ASOCIADO);
        profesores.add(profesor4);
        
        Profesor profesor5 = new Profesor(10, "J", "j", "C10", Cargo.JTP);
        profesores.add(profesor5);
        
//        for(Profesor p: profesores){
//            p.mostrar();
//        }
        
        //Instanciar Idioma y agregarlos al ArrayList
        Idioma idioma1 = new Idioma("Español");
        idiomas.add(idioma1);
        Idioma idioma2 = new Idioma("Inglés");
        idiomas.add(idioma2);
        Idioma idioma3 = new Idioma("Alemán");
        idiomas.add(idioma3);
        Idioma idioma4 = new Idioma("Francés");
        idiomas.add(idioma4);
        Idioma idioma5 = new Idioma("Italiano");
        idiomas.add(idioma5);
        
        //Instanciar Lugar y agregarlos al ArrayList
        Lugar lugar1 = new Lugar("A1");
        lugares.add(lugar1);
        Lugar lugar2 = new Lugar("A2");
        lugares.add(lugar2);
        Lugar lugar3 = new Lugar("A3");
        lugares.add(lugar3);
        Lugar lugar4 = new Lugar("A4");
        lugares.add(lugar4);
        Lugar lugar5 = new Lugar("B1");
        lugares.add(lugar5);
        
        //Instanciar PalabraClave y agregarlos al ArrayList
        PalabraClave palabraClave1 = new PalabraClave("Clave 1");
        palabrasClaves.add(palabraClave1);
        PalabraClave palabraClave2 = new PalabraClave("Clave 2");
        palabrasClaves.add(palabraClave2);
        PalabraClave palabraClave3 = new PalabraClave("Clave 3");
        palabrasClaves.add(palabraClave3);
        PalabraClave palabraClave4 = new PalabraClave("Clave 4");
        palabrasClaves.add(palabraClave4);
        PalabraClave palabraClave5 = new PalabraClave("Clave 5");
        palabrasClaves.add(palabraClave5);
        
        //Instanciar Tipo y agregarlos al ArrayList
        Tipo tipo1 = new Tipo("Anfiteatro");
        tipos.add(tipo1);
        Tipo tipo2 = new Tipo("Aula");
        tipos.add(tipo2);
        Tipo tipo3 = new Tipo("Sala");
        tipos.add(tipo3);
        Tipo tipo4 = new Tipo("Oficina");
        tipos.add(tipo4);
        Tipo tipo5 = new Tipo("Laboratorio");
        tipos.add(tipo5);
        
        //Instanciar Grupo y agregarlos al ArrayList
        Grupo grupo1 = new Grupo("G1", "g1");
        grupos.add(grupo1);
        
        Grupo grupo2 = new Grupo("G2", "g2");
        grupos.add(grupo2);
        
        Grupo grupo3 = new Grupo("G3", "g3");
        grupos.add(grupo3);
        
        Grupo grupo4 = new Grupo("G4", "g4");
        grupos.add(grupo4);
        
        Grupo grupo5 = new Grupo("G5", "g5");
        grupos.add(grupo5);
        
//        for(Grupo g: grupos){
//            g.mostrar();
//        }

        JDialog ventanaPadre = new JDialog();
        ventanaPadre.setSize(500, 500);
        ventanaPadre.setVisible(true);
        ventanaPadre.setLocationRelativeTo(null);
        ventanaPadre.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        VentanaAMAlumno ventanaAlumno = new VentanaAMAlumno(ventanaPadre);
        VentanaAMProfesor ventanaProfesor = new VentanaAMProfesor (ventanaPadre);
        VentanaAIdioma ventanaIdioma = new VentanaAIdioma (ventanaPadre);
        VentanaALugar ventanaLugar = new VentanaALugar (ventanaPadre);
        VentanaAPalabraClave ventanaPalabraClave = new VentanaAPalabraClave (ventanaPadre);
        VentanaATipo ventanaTipo = new VentanaATipo (ventanaPadre);
        VentanaAMGrupo ventanaGrupo = new VentanaAMGrupo (ventanaPadre);

        MiembroEnGrupo miembroEnGrupo = new MiembroEnGrupo (profesor1, grupo1, Rol.ADMINISTRADOR);
        
        Publicacion pub1 = new Publicacion("Título 5", LocalDate.now(), "Enlace 5", "Resumen 5", tipo1, idioma1, lugar1, miembroEnGrupo,palabrasClaves);
        pub1.mostrar();
    }
}
