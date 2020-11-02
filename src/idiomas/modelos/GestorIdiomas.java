/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idiomas.modelos;

import java.util.ArrayList;
import idiomas.modelos.GestorIdiomas;
import idiomas.modelos.Idioma;
import interfaces.IGestorIdiomas;
//import interfaces.IGestorTipos;

/**
 *
 * @author Carlos
 */
public class GestorIdiomas implements IGestorIdiomas{
    private ArrayList<Idioma> idiomas = new ArrayList<> ();
    public static final String EXITO = "El nuevo 'Idioma' fue creado con éxito";
    public static final String REPETIDO = "ERROR. El nuevo 'Idioma' ya fue creado";
    public static final String INVALIDO = "ERROR. El nombre ingresado es inválido";
    public static final String INSTANCIADO = "ERROR. Un objeto de esta clase ya ha sido creado";
    
    private static GestorIdiomas instancia;
    
    public static GestorIdiomas crear () {
        if (instancia == null){
            instancia = new GestorIdiomas();
        }
        else{
            System.out.println(INSTANCIADO);
        }
        return instancia;
    }
    

    public String nuevoIdioma(String nombre) {
        if ((nombre != null) && (!nombre.isBlank())){
            Idioma i = new Idioma(nombre);
            if (!this.idiomas.contains(i)){
               this.idiomas.add(i);
               return EXITO;
            }
            else {
                return REPETIDO;
            }
        }
        else {
            return INVALIDO;
        }
    }

    public ArrayList<Idioma> verIdiomas() {
        return idiomas;
    }

    
    public Idioma verIdioma(String nombre) {
        for (Idioma i : idiomas){
            if (i.verNombre() == nombre){
                return i;
            }
        }
        return null;
    }
}
