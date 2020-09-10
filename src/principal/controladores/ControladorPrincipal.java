/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.controladores;

import autores.modelos.Alumno;
import autores.modelos.Profesor;
import grupos.modelos.Grupo;
import idiomas.modelos.Idioma;
import java.util.ArrayList;
import lugares.modelos.Lugar;
import palabrasclaves.modelos.PalabraClave;
import tipos.modelos.Tipo;

public class ControladorPrincipal {
    public static void main(String args[]) {
        ArrayList<Alumno> arrayAlumno = new ArrayList<>();
        ArrayList<Profesor> arrayProfesor = new ArrayList<>();
        ArrayList<Idioma> arrayIdioma = new ArrayList<>();
        ArrayList<Lugar> arrayLugar = new ArrayList<>();
        ArrayList<PalabraClave> arrayPalabraClave = new ArrayList<>();
        ArrayList<Tipo> arrayTipo = new ArrayList<>();
        ArrayList<Grupo> arrayGrupo = new ArrayList<>();
        
        //Instanciar Alumnos y agregarlos al ArrayList
        Alumno alumno1 = new Alumno();
        alumno1.asignarDni(1);
        alumno1.asignarApellidos("A");
        alumno1.asignarNombres("a");
        alumno1.asignarCx("1-1");
        alumno1.asignarClave("C1");
        arrayAlumno.add(alumno1);
        
        Alumno alumno2 = new Alumno();
        alumno2.asignarDni(2);
        alumno2.asignarApellidos("B");
        alumno2.asignarNombres("b");
        alumno2.asignarCx("1-2");
        alumno2.asignarClave("C2");
        arrayAlumno.add(alumno2);
        
        Alumno alumno3 = new Alumno();
        alumno3.asignarDni(2);
        alumno3.asignarApellidos("C");
        alumno3.asignarNombres("c");
        alumno3.asignarCx("1-3");
        alumno3.asignarClave("C3");
        arrayAlumno.add(alumno3);
        
        Alumno alumno4 = new Alumno();
        alumno4.asignarDni(4);
        alumno4.asignarApellidos("D");
        alumno4.asignarNombres("d");
        alumno4.asignarCx("1-4");
        alumno4.asignarClave("C4");
        arrayAlumno.add(alumno4);
        
        Alumno alumno5 = new Alumno();
        alumno5.asignarDni(5);
        alumno5.asignarApellidos("E");
        alumno5.asignarNombres("e");
        alumno5.asignarCx("1-5");
        alumno5.asignarClave("C5");
        arrayAlumno.add(alumno5);
        
        for(Alumno a: arrayAlumno){
            a.mostrar();
        }
        
        //Instanciar Profesor y agregarlos al ArrayList
        Profesor profesor1 = new Profesor();
        profesor1.asignarApellidos("F");
        profesor1.asignarNombres("f");
        profesor1.asignarDni(6);
        profesor1.asignarCargo("FF");
        profesor1.asignarClave("C6");
        arrayProfesor.add(profesor1);
       
        
        Profesor profesor2 = new Profesor();
        profesor2.asignarApellidos("G");
        profesor2.asignarNombres("g");
        profesor2.asignarDni(7);
        profesor2.asignarCargo("GG");
        profesor2.asignarClave("C7");
        arrayProfesor.add(profesor2);
        
        Profesor profesor3 = new Profesor();
        profesor3.asignarApellidos("H");
        profesor3.asignarNombres("h");
        profesor3.asignarDni(8);
        profesor3.asignarCargo("HH");
        profesor3.asignarClave("C8");
        arrayProfesor.add(profesor3);
        
        Profesor profesor4 = new Profesor();
        profesor4.asignarApellidos("I");
        profesor4.asignarNombres("i");
        profesor4.asignarDni(9);
        profesor4.asignarCargo("II");
        profesor4.asignarClave("C9");
        arrayProfesor.add(profesor4);
        
        Profesor profesor5 = new Profesor();
        profesor5.asignarApellidos("J");
        profesor5.asignarNombres("j");
        profesor5.asignarDni(10);
        profesor5.asignarCargo("JJ");
        profesor5.asignarClave("C10");
        arrayProfesor.add(profesor5);
        
        for(Profesor p: arrayProfesor){
            p.mostrar();
        }
        
        //Instanciar Idioma y agregarlos al ArrayList
        Idioma idioma1 = new Idioma();
        arrayIdioma.add(idioma1);
        Idioma idioma2 = new Idioma();
        arrayIdioma.add(idioma2);
        Idioma idioma3 = new Idioma();
        arrayIdioma.add(idioma3);
        Idioma idioma4 = new Idioma();
        arrayIdioma.add(idioma4);
        Idioma idioma5 = new Idioma();
        arrayIdioma.add(idioma5);
        
        //Instanciar Lugar y agregarlos al ArrayList
        Lugar lugar1 = new Lugar();
        arrayLugar.add(lugar1);
        Lugar lugar2 = new Lugar();
        arrayLugar.add(lugar2);
        Lugar lugar3 = new Lugar();
        arrayLugar.add(lugar3);
        Lugar lugar4 = new Lugar();
        arrayLugar.add(lugar4);
        Lugar lugar5 = new Lugar();
        arrayLugar.add(lugar5);
        
        //Instanciar PalabraClave y agregarlos al ArrayList
        PalabraClave palabraClave1 = new PalabraClave();
        arrayPalabraClave.add(palabraClave1);
        PalabraClave palabraClave2 = new PalabraClave();
        arrayPalabraClave.add(palabraClave2);
        PalabraClave palabraClave3 = new PalabraClave();
        arrayPalabraClave.add(palabraClave3);
        PalabraClave palabraClave4 = new PalabraClave();
        arrayPalabraClave.add(palabraClave4);
        PalabraClave palabraClave5 = new PalabraClave();
        arrayPalabraClave.add(palabraClave5);
        
        //Instanciar Tipo y agregarlos al ArrayList
        Tipo tipo1 = new Tipo();
        arrayTipo.add(tipo1);
        Tipo tipo2 = new Tipo();
        arrayTipo.add(tipo2);
        Tipo tipo3 = new Tipo();
        arrayTipo.add(tipo3);
        Tipo tipo4 = new Tipo();
        arrayTipo.add(tipo4);
        Tipo tipo5 = new Tipo();
        arrayTipo.add(tipo5);
        
        //Instanciar Grupo y agregarlos al ArrayList
        Grupo grupo1 = new Grupo();
        grupo1.asignarNombre("G1");
        grupo1.asignarDescripcion("g1");
        arrayGrupo.add(grupo1);
        
        Grupo grupo2 = new Grupo();
        grupo2.asignarNombre("G2");
        grupo2.asignarDescripcion("g2");
        arrayGrupo.add(grupo2);
        
        Grupo grupo3 = new Grupo();
        grupo3.asignarNombre("G3");
        grupo3.asignarDescripcion("g3");
        arrayGrupo.add(grupo3);
        
        Grupo grupo4 = new Grupo();
        grupo4.asignarNombre("G4");
        grupo4.asignarDescripcion("g4");
        arrayGrupo.add(grupo4);
        
        Grupo grupo5 = new Grupo();
        grupo5.asignarNombre("G5");
        grupo5.asignarDescripcion("g5");
        arrayGrupo.add(grupo5);
        
        for(Grupo g: arrayGrupo){
            g.mostrar();
        }
    }
}
