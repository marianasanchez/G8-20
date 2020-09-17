/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.controladores;

import autores.vistas.VentanaAMAlumno;
import autores.vistas.VentanaAMProfesor;
import grupos.vistas.VentanaAMGrupo;
import idiomas.vistas.VentanaAIdioma;
import javax.swing.JDialog;
import lugares.vistas.VentanaALugar;
import palabrasclaves.vistas.VentanaAPalabraClave;
import tipos.vistas.VentanaATipo;

public class ControladorPrincipal {
    public static void main(String args[]) {
//        ArrayList<Alumno> arrayAlumno = new ArrayList<>();
//        ArrayList<Profesor> arrayProfesor = new ArrayList<>();
//        ArrayList<Idioma> arrayIdioma = new ArrayList<>();
//        ArrayList<Lugar> arrayLugar = new ArrayList<>();
//        ArrayList<PalabraClave> arrayPalabraClave = new ArrayList<>();
//        ArrayList<Tipo> arrayTipo = new ArrayList<>();
//        ArrayList<Grupo> arrayGrupo = new ArrayList<>();
//        
//        //Instanciar Alumnos y agregarlos al ArrayList
//        Alumno alumno1 = new Alumno(1, "A", "a", "1-1", "C1");
//        arrayAlumno.add(alumno1);
//        
//        Alumno alumno2 = new Alumno(2, "B", "b", "1-2", "C2");
//        arrayAlumno.add(alumno2);
//        
//        Alumno alumno3 = new Alumno(3, "C", "c", "1-3", "C3");
//        arrayAlumno.add(alumno3);
//        
//        Alumno alumno4 = new Alumno(4, "D", "d", "1-4", "C4");
//        arrayAlumno.add(alumno4);
//        
//        Alumno alumno5 = new Alumno(5, "D", "d", "1-5", "C5");
//        arrayAlumno.add(alumno5);
//        
//        for(Alumno a: arrayAlumno){
//            a.mostrar();
//        }
//        
//        //Instanciar Profesor y agregarlos al ArrayList
//        Profesor profesor1 = new Profesor(6, "F", "f", "C6", "FF");
//        arrayProfesor.add(profesor1);
//       
//        Profesor profesor2 = new Profesor(7, "G", "g", "C7", "GG");
//        arrayProfesor.add(profesor2);
//        
//        Profesor profesor3 = new Profesor(8, "H", "h", "C8", "HH");
//        arrayProfesor.add(profesor3);
//        
//        Profesor profesor4 = new Profesor(9, "I", "i", "C9", "II");
//        arrayProfesor.add(profesor4);
//        
//        Profesor profesor5 = new Profesor(10, "J", "j", "C10", "JJ");
//        arrayProfesor.add(profesor5);
//        
//        for(Profesor p: arrayProfesor){
//            p.mostrar();
//        }
//        
//        //Instanciar Idioma y agregarlos al ArrayList
//        Idioma idioma1 = new Idioma("Español");
//        arrayIdioma.add(idioma1);
//        Idioma idioma2 = new Idioma("Inglés");
//        arrayIdioma.add(idioma2);
//        Idioma idioma3 = new Idioma("Alemán");
//        arrayIdioma.add(idioma3);
//        Idioma idioma4 = new Idioma("Francés");
//        arrayIdioma.add(idioma4);
//        Idioma idioma5 = new Idioma("Italiano");
//        arrayIdioma.add(idioma5);
//        
//        //Instanciar Lugar y agregarlos al ArrayList
//        Lugar lugar1 = new Lugar("A1");
//        arrayLugar.add(lugar1);
//        Lugar lugar2 = new Lugar("A2");
//        arrayLugar.add(lugar2);
//        Lugar lugar3 = new Lugar("A3");
//        arrayLugar.add(lugar3);
//        Lugar lugar4 = new Lugar("A4");
//        arrayLugar.add(lugar4);
//        Lugar lugar5 = new Lugar("B1");
//        arrayLugar.add(lugar5);
//        
//        //Instanciar PalabraClave y agregarlos al ArrayList
//        PalabraClave palabraClave1 = new PalabraClave("Clave 1");
//        arrayPalabraClave.add(palabraClave1);
//        PalabraClave palabraClave2 = new PalabraClave("Clave 2");
//        arrayPalabraClave.add(palabraClave2);
//        PalabraClave palabraClave3 = new PalabraClave("Clave 3");
//        arrayPalabraClave.add(palabraClave3);
//        PalabraClave palabraClave4 = new PalabraClave("Clave 4");
//        arrayPalabraClave.add(palabraClave4);
//        PalabraClave palabraClave5 = new PalabraClave("Clave 5");
//        arrayPalabraClave.add(palabraClave5);
//        
//        //Instanciar Tipo y agregarlos al ArrayList
//        Tipo tipo1 = new Tipo("Anfiteatro");
//        arrayTipo.add(tipo1);
//        Tipo tipo2 = new Tipo("Aula");
//        arrayTipo.add(tipo2);
//        Tipo tipo3 = new Tipo("Sala");
//        arrayTipo.add(tipo3);
//        Tipo tipo4 = new Tipo("Oficina");
//        arrayTipo.add(tipo4);
//        Tipo tipo5 = new Tipo("Laboratorio");
//        arrayTipo.add(tipo5);
//        
//        //Instanciar Grupo y agregarlos al ArrayList
//        Grupo grupo1 = new Grupo("G1", "g1");
//        arrayGrupo.add(grupo1);
//        
//        Grupo grupo2 = new Grupo("G2", "g2");
//        arrayGrupo.add(grupo2);
//        
//        Grupo grupo3 = new Grupo("G3", "g3");
//        arrayGrupo.add(grupo3);
//        
//        Grupo grupo4 = new Grupo("G4", "g4");
//        arrayGrupo.add(grupo4);
//        
//        Grupo grupo5 = new Grupo("G5", "g5");
//        arrayGrupo.add(grupo5);
//        
//        for(Grupo g: arrayGrupo){
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
        
    }
}
