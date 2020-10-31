/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipos.modelos;

import interfaces.IGestorTipos;
import java.util.ArrayList;

public class GestorTipos implements IGestorTipos{

    private ArrayList<Tipo> tipos = new ArrayList<> ();
    public static final String EXITO = "El nuevo 'Tipo' fue creado con éxito";
    public static final String REPETIDO = "El nuevo 'Tipo' ya fue creado";
    public static final String INVALIDO = "El nombre ingresado es inválido";
    
    private static GestorTipos instancia;
    
    public static GestorTipos crear () {
        if (instancia == null){
            instancia = new GestorTipos();
        }
        return instancia;
    }
    
    @Override
    public String nuevoTipo(String nombre) {
        if ((!nombre.isBlank() && (nombre != null))){
            Tipo t = new Tipo(nombre);
            if (!this.tipos.contains(t)){
               this.tipos.add(t);
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

    @Override
    public ArrayList<Tipo> verTipos() {
        return tipos;
    }

    @Override
    public Tipo verTipo(String nombre) {
        for (Tipo t : tipos){
            if (t.verNombre() == nombre){
                return t;
            }
        }
        return null;
    }
    
}
