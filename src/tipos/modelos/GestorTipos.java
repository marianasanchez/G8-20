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
    public static final String REPETIDO = "ERROR. El nuevo 'Tipo' ya fue creado";
    public static final String INVALIDO = "ERROR. El nombre ingresado es inválido";
    public static final String INSTANCIADO = "ERROR. Un objeto de esta clase ya ha sido creado";
    
    private static GestorTipos instancia;
    
    public static GestorTipos crear () {
        if (instancia == null){
            instancia = new GestorTipos();
        }
        else{
            System.out.println(INSTANCIADO);
        }
        return instancia;
    }
    
    @Override
    public String nuevoTipo(String nombre) {
        if ((nombre != null) && (!nombre.isBlank())){
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
