/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lugares.modelos;

import java.util.ArrayList;
import interfaces.IGestorLugares;
/**
 *
 * @author Carlos
 */
public class GestorLugares implements IGestorLugares{
     private ArrayList<Lugar> lugares = new ArrayList<> ();
    public static final String EXITO = "El nuevo 'Lugar' fue creado con éxito";
    public static final String REPETIDO = "ERROR. El nuevo 'Lugar' ya fue creado";
    public static final String INVALIDO = "ERROR. El nombre ingresado es inválido";
    public static final String INSTANCIADO = "ERROR. Un objeto de esta clase ya ha sido creado";
    
    private static GestorLugares instancia;
    
    public static GestorLugares crear () {
        if (instancia == null){
            instancia = new GestorLugares();
        }
        else{
            System.out.println(INSTANCIADO);
        }
        return instancia;
    }
    

    public String nuevoLugar(String nombre) {
        if ((nombre != null) && (!nombre.isBlank())){
            Lugar l = new Lugar(nombre);
            if (!this.lugares.contains(l)){
               this.lugares.add(l);
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

 
    public ArrayList<Lugar> verLugares() {
        return lugares;
    }


    public Lugar verLugar(String nombre) {
        for (Lugar l : lugares){
            if (l.verNombre() == nombre){
                return l;
            }
        }
        return null;
    }
    
}
